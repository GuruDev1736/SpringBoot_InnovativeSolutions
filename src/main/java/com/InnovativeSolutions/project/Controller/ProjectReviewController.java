package com.InnovativeSolutions.project.Controller;

import com.InnovativeSolutions.project.Payload.ProjectReviewsDTO;
import com.InnovativeSolutions.project.Service.ProjectReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ProjectReviewController {

    private ProjectReviewService projectReviewService ;

    public ProjectReviewController(ProjectReviewService projectReviewService) {
        this.projectReviewService = projectReviewService;
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<ProjectReviewsDTO> addreview (@PathVariable(name = "id") Long projectId , @RequestBody ProjectReviewsDTO projectReviewsDTO)
    {
        ProjectReviewsDTO add = projectReviewService.addreview(projectId,projectReviewsDTO);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/all")
    public ResponseEntity<List<ProjectReviewsDTO>> getall( @PathVariable(name = "id") Long projectId)
    {
        return new ResponseEntity<>(projectReviewService.getall(projectId),HttpStatus.OK);
    }

    @GetMapping("/{id}/{rid}")
    public ResponseEntity<ProjectReviewsDTO> getbyid (@PathVariable(name = "id") Long projectId , @PathVariable(name = "rid") Long reviewId)
    {
        return new ResponseEntity<>(projectReviewService.getbyid(projectId,reviewId),HttpStatus.OK);
    }
}
