package com.aula.pos.appinscricao.controller.v1;

import com.aula.pos.appinscricao.dto.ErrorResponse;
import com.aula.pos.appinscricao.dto.PessoaRequest;
import com.aula.pos.appinscricao.dto.PessoaResponse;
import com.aula.pos.appinscricao.exception.ApiException;
import com.aula.pos.appinscricao.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    public Page<PessoaResponse> findAll(
            @RequestParam(required = false) String nome,
            @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable
    ){
        return pessoaService.findAll(nome, pageable);
    }

    //http://localhost:8080/api/v1/pessoas/1243563563536
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        try {
            return ResponseEntity.ok(pessoaService.findById(id));
        }catch (ApiException e){
            return ResponseEntity
                    .status(e.getStatus())
                    .body(new ErrorResponse(LocalDateTime.now(), e.getStatus().value(), e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> save(@Valid @RequestBody PessoaRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable UUID id,
            @Valid @RequestBody PessoaRequest request
    ){
        try{
            return ResponseEntity.ok(pessoaService.update(id, request));
        }catch(ApiException e){
            return ResponseEntity
                    .status(e.getStatus())
                    .body(new ErrorResponse(LocalDateTime.now(), e.getStatus().value(), e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        try{
            pessoaService.deleById(id);
            return ResponseEntity.noContent().build();
        }catch (ApiException e){
            return ResponseEntity
                    .status(e.getStatus())
                    .body(new ErrorResponse(LocalDateTime.now(), e.getStatus().value(), e.getMessage()));
        }
    }
}
