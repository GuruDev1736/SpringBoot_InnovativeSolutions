package com.InnovativeSolutions.project.Controller;

import com.InnovativeSolutions.project.Payload.ProjectImagesDTO;
import com.InnovativeSolutions.project.Service.ProjectImagesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ProjectImagesController {
    private ProjectImagesService projectImagesService ;

    public ProjectImagesController(ProjectImagesService projectImagesService) {
        this.projectImagesService = projectImagesService;
    }

    @PostMapping("/add/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProjectImagesDTO> addimages(@PathVariable(name = "id") Long projectId , @RequestBody ProjectImagesDTO projectImagesDTO)
    {
        ProjectImagesDTO add = projectImagesService.addimage(projectId,projectImagesDTO);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @GetMapping("{id}/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ProjectImagesDTO>> listimages ( @PathVariable(name = "id") Long projectId)
    {
        return new ResponseEntity<>(projectImagesService.listimage(projectId),HttpStatus.OK);
    }

    @GetMapping("/{id}/{imageId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProjectImagesDTO> getbyid( @PathVariable(name = "id") Long projectId , @PathVariable(name = "imageId") Long imageId) {
        return new ResponseEntity<>(projectImagesService.getimagebyid(projectId, imageId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/{Iid}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteimage(@PathVariable(name = "id") Long projectId , @PathVariable(name = "Iid") Long imageId)
    {
        projectImagesService.deleteimage(projectId,imageId);
        return new ResponseEntity<>("Image of project : "+projectId+" with id : "+imageId+" has deleted",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteall ( @PathVariable(name = "id") Long projectId)
    {
        projectImagesService.deleteall(projectId);
        return new ResponseEntity<>("All images of project id :"+projectId+" has deleted",HttpStatus.OK);
    }


}
