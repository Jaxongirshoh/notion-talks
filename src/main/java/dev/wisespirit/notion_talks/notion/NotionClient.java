package dev.wisespirit.notion_talks.notion;

import dev.wisespirit.notion_talks.notion.service.DatabaseService;
import org.springframework.stereotype.Component;

@Component
public class NotionClient {
    public final DatabaseService databaseService;
    public NotionClient(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }
}
