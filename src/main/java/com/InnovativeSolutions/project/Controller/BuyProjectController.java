package com.InnovativeSolutions.project.Controller;

import com.InnovativeSolutions.project.Model.BuyProject;
import com.InnovativeSolutions.project.Payload.BuyProjectDTO;
import com.InnovativeSolutions.project.Service.BuyProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buy")
public class BuyProjectController {
    private BuyProjectService buyProjectService ;

    public BuyProjectController(BuyProjectService buyProjectService) {
        this.buyProjectService = buyProjectService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BuyProjectDTO> addproject ( @RequestBody BuyProjectDTO buyProjectDTO)
    {
        BuyProjectDTO add = buyProjectService.addproject(buyProjectDTO);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BuyProjectDTO>> getall()
    {
        return new ResponseEntity<>(buyProjectService.getAllProjects(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuyProjectDTO> getprojectbyid( @PathVariable(name = "id") Long projectId)
    {
        return new ResponseEntity<>(buyProjectService.getProjectById(projectId),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BuyProjectDTO> updateproject ( @PathVariable(name = "id") Long projectId , @RequestBody BuyProjectDTO buyProjectDTO)
    {
        return new ResponseEntity<>(buyProjectService.updateproject(projectId,buyProjectDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteproject (@PathVariable(name = "id") Long projectId)
    {
        buyProjectService.deleteproject(projectId);
        return new ResponseEntity<>("The Project with Id : "+projectId+" has deleted",HttpStatus.OK);
    }

    @DeleteMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteall ()
    {
        buyProjectService.deleteall();
        return new ResponseEntity<>("All Projects Has been deleted",HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BuyProject>> search (@RequestParam("query") String query)
    {
        return new ResponseEntity<>(buyProjectService.search(query),HttpStatus.OK);
    }



}
