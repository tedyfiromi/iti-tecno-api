package br.com.itau.ititecnoapi.controller;

import br.com.itau.ititecnoapi.dto.ConfigDTO;
import br.com.itau.ititecnoapi.model.Config;
import br.com.itau.ititecnoapi.response.Response;
import br.com.itau.ititecnoapi.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/config")
public class ConfigController {

    @Autowired
    private ConfigService service;

    @ApiOperation(value = "Set the default password")
    @PostMapping
    public ResponseEntity<Response<Config>> config(@RequestBody ConfigDTO configDTO) {

        Response<Config> configResponse = new Response<>();
        Config config = new Config();

        BeanUtils.copyProperties(configDTO, config);

        Config configObject = service.configure(config);
        configResponse.setObject(configObject);

        if (configResponse == null) {
            return ResponseEntity.badRequest().body(configResponse);
        }

        return ResponseEntity.ok(configResponse);
    }

    @ApiOperation(value = "Show password default")
    @GetMapping
    public ResponseEntity<Response<Config>> getConfig() {

        Response<Config> configResponse = new Response<>();

        Config config = service.findLastConfiguration();

        if (config == null) {
            return ResponseEntity.notFound().build();
        }

        configResponse.setObject(config);

        return ResponseEntity.ok(configResponse);
    }
}
