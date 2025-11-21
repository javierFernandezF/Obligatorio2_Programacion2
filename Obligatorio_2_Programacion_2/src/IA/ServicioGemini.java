/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author javierfernandez
 */
public class ServicioGemini {
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";
    private final String apiKey;
    private final Gson gson;
    
    public ServicioGemini() {
        // Verificar que la API key esté configurada
        this.apiKey = System.getenv("ERP_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("La variable de entorno ERP_API_KEY no está configurada");
        }
        
        // Inicializar Gson
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    public String generarReporteInteligente(String areaOrigen, String descripcionOrigen, 
                                          String areaDestino, String descripcionDestino, 
                                          String cvEmpleado) throws Exception {
        
        String prompt = construirPrompt(areaOrigen, areaDestino, cvEmpleado);
        
        try {
            // Crear JSON usando Gson de forma simple
            String jsonRequest = crearJsonConGson(prompt);
            
            // Realizar la petición HTTP a Gemini 2.5 Flash
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("x-goog-api-key", apiKey);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            
            // Enviar la petición
            try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8)) {
                writer.write(jsonRequest);
                writer.flush();
            }
            
            // Leer la respuesta
            int responseCode = connection.getResponseCode();
            
            if (responseCode == 200) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    
                    String responseStr = response.toString();
                    
                    // Parsear respuesta con Gson (simple)
                    String texto = extraerTextoConGson(responseStr);
                    return texto;
                }
            } else {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8))) {
                    StringBuilder error = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        error.append(line);
                    }
                    String errorStr = error.toString();
                    
                    throw new Exception("Error en la API de Gemini (" + responseCode + "): " + errorStr);
                }
            }
        } catch (IOException e) {
            throw new Exception("Error de conexión con la API de Gemini: " + e.getMessage(), e);
        }
    }
    
    private String construirPrompt(String areaOrigen,  
                                 String areaDestino, 
                                 String cvEmpleado) {
        return "Empleado: " + cvEmpleado + ". Cambio: " + areaOrigen + "→" + areaDestino + 
               ". Responde SOLO con formato: VENTAJAS: 1. 2. 3. DESVENTAJAS: 1. 2. 3. Máximo 50 palabras total.";
    }
    
    
    // Método simple para crear JSON con Gson
    private String crearJsonConGson(String prompt) {
        // Crear un Map simple para el JSON
        java.util.Map<String, Object> request = new java.util.HashMap<>();
        
        // Contents
        java.util.Map<String, Object> part = new java.util.HashMap<>();
        part.put("text", prompt);
        
        java.util.Map<String, Object> content = new java.util.HashMap<>();
        content.put("parts", java.util.Arrays.asList(part));
        
        request.put("contents", java.util.Arrays.asList(content));
        
        // GenerationConfig
        java.util.Map<String, Object> config = new java.util.HashMap<>();
        config.put("temperature", 0.7);
        config.put("topK", 40);
        config.put("topP", 0.95);
        config.put("maxOutputTokens", 512);
        
        // ThinkingConfig para deshabilitar el pensamiento automático
        java.util.Map<String, Object> thinkingConfig = new java.util.HashMap<>();
        thinkingConfig.put("thinkingBudget", 0);
        config.put("thinkingConfig", thinkingConfig);
        
        request.put("generationConfig", config);
        
        // SystemInstruction
        java.util.Map<String, Object> systemPart = new java.util.HashMap<>();
        systemPart.put("text", "SÉ BREVE. NO pienses. NO expliques. SOLO responde el formato pedido.");
        
        java.util.Map<String, Object> systemInstruction = new java.util.HashMap<>();
        systemInstruction.put("parts", java.util.Arrays.asList(systemPart));
        request.put("systemInstruction", systemInstruction);
        
        return gson.toJson(request);
    }
    
    // Método simple para extraer texto con Gson
    private String extraerTextoConGson(String jsonResponse) {
        try {
            java.util.Map response = gson.fromJson(jsonResponse, java.util.Map.class);
            java.util.List candidates = (java.util.List) response.get("candidates");
            if (candidates != null && !candidates.isEmpty()) {
                java.util.Map candidate = (java.util.Map) candidates.get(0);
                java.util.Map content = (java.util.Map) candidate.get("content");
                if (content != null) {
                    java.util.List parts = (java.util.List) content.get("parts");
                    if (parts != null && !parts.isEmpty()) {
                        java.util.Map part = (java.util.Map) parts.get(0);
                        return (String) part.get("text");
                    }
                }
            }
            return "No se pudo obtener respuesta de la API";
        } catch (Exception e) {
            return "Error al procesar respuesta: " + e.getMessage();
        }
    }
}
