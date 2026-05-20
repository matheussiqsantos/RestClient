
package br.dev.matheus.restclient.cepService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private CepService cepService;
    
    @GetMapping("/cep/{cepId}")
    public ResponseEntity<CepDTO> buscaCep(@PathVariable String cepId) {
        
        Optional<CepDTO> optCepDTO = cepService.buscarCep(cepId);
        if (optCepDTO.isPresent()) {
            return ResponseEntity.ok(optCepDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/status")
    public Map<String, String> getMyControllerStatus() {
        Map status = new HashMap();
        status.put("status", "Ok");
        return status;
    }
 
}
