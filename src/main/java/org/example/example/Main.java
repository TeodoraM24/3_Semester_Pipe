package org.example.example;

import io.javalin.Javalin;
import org.example.example.controllers.DogController;

public class Main {
    public static void main(String[] args) {
        DogController dogController = new DogController();


        Javalin app = Javalin.create().start(7007);

        // Updated path parameter syntax
        app.get("/api/dogs", ctx -> ctx.json(dogController.getAllDogs()));
        app.get("/api/dog/{id}", ctx -> {  // Changed :id to {id}
            String id = ctx.pathParam("id");
            ctx.json(dogController.getDogById(id));
        });
        app.post("/api/dog", dogController::createDog);
        app.put("/api/dog/{id}", ctx -> {  // Changed :id to {id}
            String id = ctx.pathParam("id");
            dogController.updateDog(ctx, id);
        });
        app.delete("/api/dog/{id}", ctx -> {  // Changed :id to {id}
            String id = ctx.pathParam("id");
            dogController.deleteDog(ctx, id);
        });
    }
}
