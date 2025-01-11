package dev.wisespirit.notion_talks.notion.service;

import dev.wisespirit.notion_talks.notion.config.NotionConfigProperties;
import dev.wisespirit.notion_talks.notion.model.Database;
import dev.wisespirit.notion_talks.notion.model.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class DatabaseService {
    private final NotionConfigProperties notionConfigProperties;
    private final RestClient restClient;
    private final Logger log = LoggerFactory.getLogger(DatabaseService.class);
    public DatabaseService(NotionConfigProperties notionConfigProperties, RestClient restClient) {
        this.notionConfigProperties = notionConfigProperties;
        this.restClient = restClient;
    }

    public List<Page> query(String databaseId){
        String url = notionConfigProperties.apiUrl()+"/v1/databases/"+databaseId+"/query";
        log.info("Querying for database {} ",url);
        ResponseEntity<Database> notionResponse = restClient.post()
                .uri(url)
                .headers(httpHeaders -> {
                    httpHeaders.set("Content-Type", "application/json");
                    httpHeaders.set("Notion-Version", notionConfigProperties.apiVersion());
                    httpHeaders.set("Authorization", notionConfigProperties.authToken());
                })
                .retrieve()
                .toEntity(Database.class);
        return notionResponse.getBody().getPages();
    }

}
