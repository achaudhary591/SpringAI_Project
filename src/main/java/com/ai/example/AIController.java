package com.ai.example;

import com.ai.example.model.LlamaResponse;
import com.ai.example.service.implementation.LlamaAiService;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AIController {

    @Autowired
    private final LlamaAiService llamaAiService;

    @Autowired
    public AIController(LlamaAiService llamaAiService) {
        this.llamaAiService = llamaAiService;
    }

    @GetMapping("api/v1/ai/generate")
    public ResponseEntity<LlamaResponse> generate(
            @RequestParam(value = "promptMessage", defaultValue = "Why is the sky blue?")
            String promptMessage) {
        final LlamaResponse aiResponse = llamaAiService.generateMessage(promptMessage);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }

    @GetMapping("api/v1/ai/generate/joke/{topic}")
    public ResponseEntity<LlamaResponse> generateJoke(@PathVariable String topic) {
        final LlamaResponse aiResponse = llamaAiService.generateJoke(topic);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }

}


