package com.palma.ecommerceArte.beans;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import jakarta.annotation.PostConstruct;



	@Component
	public class ProductSea1Bean {

	    @Value("classpath:images/quadroMare1.jpeg")
	    private Resource imageResource;

	   
	public String getImageUrlFromFile() throws IOException {
        byte[] imageData = StreamUtils.copyToByteArray(imageResource.getInputStream());

        // Genera l'URL basato su base64
        String base64Image = java.util.Base64.getEncoder().encodeToString(imageData);
        String imageUrl = "data:image/jpeg;base64," + base64Image;

        return imageUrl;
    }
}
