/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import java.awt.image.BufferedImage;
/**
 *
 * @author frank
 */
public class Main {
    
     //      staticFiles.location("/public");

    public static void main(String[] args) {
         staticFiles.location("/public");
         
         post("/login",(request, response)-> {
         String nombre=request.queryParams("nombre");
         String apellido=request.queryParams("apellido");
 
                 System.out.println(nombre + " " + apellido);
                 return nombre + " " + apellido;
                 });

        get("/hello", (req, res) -> "Hello World");

        get("/hola/:name", (request, response) -> {
            return "Hola: " + request.params(":name");
        });
        path("/tep", () -> {

            path("/estudiantes", () -> {
                get("/ver", (request, response) -> {
                    return "Ver estudiantes" ;
                });
                get("/listar", (request, response) -> {
                    return "Listar Esetudiantes" ;
                });

            });

        });
    }
}
