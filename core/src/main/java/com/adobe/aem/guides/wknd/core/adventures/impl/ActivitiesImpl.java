package com.adobe.aem.guides.wknd.core.adventures.impl;

import java.util.Random;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.aem.guides.wknd.core.adventures.Activities;

@Component(
    service = { Activities.class }
)
public class ActivitiesImpl implements Activities {

    private static final Logger log = LoggerFactory.getLogger(ActivitiesImpl.class);


    private static final String[] ACTIVITIES = new String[] {
        "Camping", "Skiing", "Skateboarding", 
        "Hiking", "Kayaking", "Rock climbing", 
        "Biking", "Surfing", "Birdwatching", 
        "Gardening", "Photography", "Painting", 
        "Yoga"
    };
    

    private final int randomIndex = new Random().nextInt(ACTIVITIES.length);
    // private final Random random = new Random();

    /**
     * @return the name of a random WKND adventure activity
     */
    public String getRandomActivity() {
        // int randomIndex = random.nextInt(ACTIVITIES.length);
        return ACTIVITIES[randomIndex];
    }

    @Activate
    protected void activate() {

        log.info("Activated ActivitiesImpl with activities [ {} ]", String.join(", ", ActivitiesImpl.ACTIVITIES));
    }

    @Deactivate
    protected void deactivate() {
        log.info("ActivitiesImpl has been deactivated!");
    }
}
