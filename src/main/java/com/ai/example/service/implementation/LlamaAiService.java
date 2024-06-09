package com.ai.example.service.implementation;

import com.ai.example.model.LlamaResponse;

public interface LlamaAiService {

    LlamaResponse generateMessage(String prompt);

    LlamaResponse generateJoke(String topic);
}