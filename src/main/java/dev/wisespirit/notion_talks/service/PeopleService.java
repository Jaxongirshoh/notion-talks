package dev.wisespirit.notion_talks.service;

import dev.wisespirit.notion_talks.model.People;
import dev.wisespirit.notion_talks.notion.model.Page;

public class PeopleService {

    public static People mapPaeToPeople(Page page){
        return new People(
                page.getId(),
                page.getProperties().get("Name").get("name").get(0).get("text").get("content").asText(),
                page.getProperties().get("rich_text").get(0).get("text").get("content").asText(),
                page.getProperties().get("Email").get("email").asText(),
                page.getProperties().get("URL").get("url").asText()
        );
    }
}
