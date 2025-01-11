package dev.wisespirit.notion_talks.controller;

import dev.wisespirit.notion_talks.model.People;
import dev.wisespirit.notion_talks.notion.NotionClient;
import dev.wisespirit.notion_talks.notion.config.NotionConfigProperties;
import dev.wisespirit.notion_talks.notion.model.Page;
import dev.wisespirit.notion_talks.service.PeopleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/talks")
public class PeopleController {

    private final NotionClient client;
    private final NotionConfigProperties notionConfigProperties;
    public PeopleController(NotionClient client, NotionConfigProperties notionConfigProperties) {
        this.client = client;
        this.notionConfigProperties = notionConfigProperties;
    }

    @GetMapping
    public List<People> getAll(){
        List<Page> pages = client.databaseService.query(notionConfigProperties.databaseId());
        return pages.stream().map(PeopleService::mapPaeToPeople).toList();
    }

}
