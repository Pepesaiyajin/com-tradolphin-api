package com.fakex.bitcoin;

import com.fakex.bitcoin.models.crypto.Asset;
import com.fakex.bitcoin.repositories.AssetReopository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = AssetReopository.class)
public class FakexApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FakexApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}


	private MongoTemplate mongoTemplate;

	public FakexApplication(MongoTemplate mongoTemplate){
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		Asset asset = new Asset("1","btc", "bitcoin" );
		this.mongoTemplate.save(asset);
	}
}
