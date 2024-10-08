package dat.controllers;

import io.javalin.http.Context;
import dat.dtos.DogDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogController {

    private static Map<String, DogDTO> dogMap = new HashMap<>();
    private static int idCounter = 1;

    // Retrieve all dogs
    public List<DogDTO> getAllDogs() {
        return new ArrayList<>(dogMap.values());
    }

    // Retrieve a dog by ID
    public DogDTO getDogById(String id) {
        return dogMap.get(id);
    }

    // Create a new dog
    public void createDog(Context ctx) {
        DogDTO dog = ctx.bodyAsClass(DogDTO.class);
        dog.setId(idCounter++); // Change id to int, make sure to update DogDTO if needed
        dogMap.put(String.valueOf(dog.getId()), dog); // Use String.valueOf for the map key
        ctx.status(201).json(dog); // Respond with the created dog
    }

    // Update an existing dog
    public void updateDog(Context ctx, String id) {
        DogDTO existingDog = dogMap.get(id);
        if (existingDog == null) {
            ctx.status(404).result("Dog not found");
            return;
        }
        DogDTO updatedDog = ctx.bodyAsClass(DogDTO.class);
        updatedDog.setId(Integer.parseInt(id)); // Set ID as integer
        dogMap.put(id, updatedDog);
        ctx.json(updatedDog); // Respond with the updated dog
    }

    // Delete a dog by ID
    public void deleteDog(Context ctx, String id) {
        if (dogMap.remove(id) == null) {
            ctx.status(404).result("Dog not found");
        } else {
            ctx.status(204); // No content
        }
    }
}
