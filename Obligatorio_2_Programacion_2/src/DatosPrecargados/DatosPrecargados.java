/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatosPrecargados;

import Dominio.Areas.Area;
import Dominio.Personas.Manager;
import Sistema.Sistema;

/**
 *
 * @author javierfernandez
 */
public class DatosPrecargados {
   public Sistema sistema;

public DatosPrecargados(Sistema sistema) {
    this.sistema = sistema;

    


    Area personal = new Area("Personal", "Reclutamiento de personal, promociones, gestión de cargos", 100000.00);
    sistema.getListaAreas().agregarArea(personal);
    Area rrhh = new Area("RRHH", "Relacionamiento en la empresa, organigrama, gestión de equipos", 80000.00);
    sistema.getListaAreas().agregarArea(rrhh);
    Area seguridad = new Area("Seguridad", "Seguridad física, vigilancia, seguridad informática, protocolos y políticas de seguridad", 120000.00);
    sistema.getListaAreas().agregarArea(seguridad);
    Area comunicaciones = new Area("Comunicaciones", "Comunicaciones internas, reglas y protocolos, comunicaciones con proveedores y clientes", 20000.00);
    sistema.getListaAreas().agregarArea(comunicaciones);
    Area marketing = new Area("Marketing", "Acciones planificadas, publicidad en medios masivos, publicidad en redes, gestión de redes", 95000.00);
    sistema.getListaAreas().agregarArea(marketing);

    Manager anaMartinez = new Manager("Ana Martínez", 45683691, "099123456", 10);
    sistema.getListaPersonas().agregarManager(anaMartinez);
    Manager ricardoMorales = new Manager("Ricardo Morales", 32145893, "094121212", 4);
    sistema.getListaPersonas().agregarManager(ricardoMorales);
    Manager lauraTorales = new Manager("Laura Torales", 35892575, "099654321", 1);
    sistema.getListaPersonas().agregarManager(lauraTorales);
    Manager juanPabloZapata = new Manager("Juan Pablo Zapata", 45551977, "099202020", 5);
    sistema.getListaPersonas().agregarManager(juanPabloZapata);
    }
}
