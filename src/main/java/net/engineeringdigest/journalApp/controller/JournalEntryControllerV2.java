package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

@Autowired
private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryService.getAll();

    }
    @PostMapping
    public JournalEntry createJournalEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){

        return null;
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){

        return null;
    }
    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntry(@PathVariable Long myId , @RequestBody JournalEntry myEntry) {
      return null;
    }




}
