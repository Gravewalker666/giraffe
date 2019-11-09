package org.sefglobal.giraffe.api.service.api;

import org.sefglobal.giraffe.api.beans.Board;
import org.sefglobal.giraffe.api.beans.Entity;
import org.sefglobal.giraffe.api.dao.EntityDAO;
import org.sefglobal.giraffe.api.exception.GiraffeAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class EntityManagementAPI {
    @Autowired
    private EntityDAO entityDAO;

    @GetMapping("/entities")
    public List<Entity> getAllEntities(){
        return entityDAO.getAllEntities();
    }

    @PostMapping("/entities")
    public Entity addEntity(@RequestBody Entity entity) throws GiraffeAPIException {
        return entityDAO.addEntity(entity);
    }

    @GetMapping("/entities/{id}")
    public Entity getEntityById(@PathVariable int id) throws GiraffeAPIException {
        return entityDAO.getEntityById(id);
    }

    @DeleteMapping("/entities/{id}")
    public void removeEntity(@PathVariable int id, HttpServletResponse response) throws GiraffeAPIException {
        entityDAO.removeEntity(id, response);
    }
}
