package dev.wisespirit.notion_talks;

import dev.wisespirit.notion_talks.notion.config.NotionConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(NotionConfigProperties.class)
public class NotionTalksApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotionTalksApplication.class, args);
	}

}
