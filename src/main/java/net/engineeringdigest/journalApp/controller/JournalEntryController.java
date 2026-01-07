package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.Journalentry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long , Journalentry> journalEntries = new HashMap<>();

    @GetMapping
    public List<Journalentry> getAllJournalEntries() {
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createJournalEntry(@RequestBody Journalentry myEntry) {
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public Journalentry getJournalEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public Journalentry deleteJournalEntryById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }
    @PutMapping("id/{myId}")
    public Journalentry updateJournalEntry(@PathVariable Long myId , @RequestBody Journalentry myEntry) {
        return journalEntries.put(myEntry.getId(), myEntry);
    }




}
