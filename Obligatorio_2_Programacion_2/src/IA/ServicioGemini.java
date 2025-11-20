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

/**
 *
 * @author javierfernandez
 */
public class ServicioGemini {
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";
    private final String apiKey;
    
    public ServicioGemini() {
        // Verificar que la API key esté configurada
        this.apiKey = System.getenv("ERP_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("La variable de entorno ERP_API_KEY no está configurada");
        }
    }
    
    // Sobrecarga para mantener compatibilidad con la versión original
    public String generarReporteInteligente(String areaOrigen, String descripcionOrigen, 
                                          String areaDestino, String cvEmpleado) throws Exception {
        return generarReporteInteligente(areaOrigen, descripcionOrigen, areaDestino, "", cvEmpleado);
    }
    
    public String generarReporteInteligente(String areaOrigen, String descripcionOrigen, 
                                          String areaDestino, String descripcionDestino, 
                                          String cvEmpleado) throws Exception {
        
        String prompt = construirPrompt(areaOrigen, descripcionOrigen, areaDestino, descripcionDestino, cvEmpleado);
        
        try {
            // Construir el JSON de la petición
            String jsonRequest = construirJsonRequest(prompt);
            
            // Realizar la petición HTTP a Gemini 2.5 Flash
            URL url = new URL(API_URL + "?key=" + apiKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
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
                    
                    return extraerTextoRespuesta(response.toString());
                }
            } else {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8))) {
                    StringBuilder error = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        error.append(line);
                    }
                    throw new Exception("Error en la API de Gemini (" + responseCode + "): " + error.toString());
                }
            }
        } catch (IOException e) {
            throw new Exception("Error de conexión con la API de Gemini: " + e.getMessage(), e);
        }
    }
    
    private String construirPrompt(String areaOrigen, String descripcionOrigen, 
                                 String areaDestino, String descripcionDestino, 
                                 String cvEmpleado) {
        return "Eres un consultor de recursos humanos experto. Analiza el siguiente escenario de movimiento de empleado:\n\n" +
               "ÁREA DE ORIGEN:\n" +
               "Nombre: " + areaOrigen + "\n" +
               "Descripción: " + descripcionOrigen + "\n\n" +
               "ÁREA DE DESTINO:\n" +
               "Nombre: " + areaDestino + "\n" +
               "Descripción: " + descripcionDestino + "\n\n" +
               "PERFIL DEL EMPLEADO:\n" +
               cvEmpleado + "\n\n" +
               "Por favor, proporciona un análisis detallado que incluya:\n" +
               "1. VENTAJAS del movimiento (mínimo 3 puntos)\n" +
               "2. DESVENTAJAS del movimiento (mínimo 3 puntos)\n" ;
    }
    
    private String construirJsonRequest(String prompt) {
        // Escapar comillas en el prompt
        String promptEscapado = prompt.replace("\\", "\\\\")
                                     .replace("\"", "\\\"") 
                                     .replace("\n", "\\n")
                                     .replace("\r", "\\r")
                                     .replace("\t", "\\t");
        
        return "{" +
               "\"contents\": [" +
               "{" +
               "\"parts\": [" +
               "{" +
               "\"text\": \"" + promptEscapado + "\"" +
               "}" +
               "]" +
               "}" +
               "]," +
               "\"generationConfig\": {" +
               "\"temperature\": 0.7," +
               "\"topK\": 40," +
               "\"topP\": 0.95," +
               "\"maxOutputTokens\": 2048" +
               "}" +
               "}";
    }
    
    private String extraerTextoRespuesta(String jsonResponse) {
        try {
            // Buscar el texto de respuesta en el JSON manualmente
            String textMarker = "\"text\":\"";
            int startIndex = jsonResponse.indexOf(textMarker);
            if (startIndex != -1) {
                startIndex += textMarker.length();
                int endIndex = jsonResponse.indexOf("\"", startIndex);
                if (endIndex != -1) {
                    String texto = jsonResponse.substring(startIndex, endIndex);
                    // Desescapar caracteres
                    return texto.replace("\\n", "\n")
                               .replace("\\r", "\r")
                               .replace("\\t", "\t")
                               .replace("\\\"", "\"")
                               .replace("\\\\", "\\");
                }
            }
            return "No se pudo obtener respuesta de la API";
        } catch (Exception e) {
            return "Error al procesar la respuesta: " + e.getMessage();
        }
    }
}
