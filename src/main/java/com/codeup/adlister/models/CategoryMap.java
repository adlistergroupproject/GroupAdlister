package com.codeup.adlister.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CategoryMap {

    private HashMap<String, String> categories;

    public CategoryMap() {
        this.categories = new HashMap<>();
        this.categories.put("ACTIVITIES", "activities");
        this.categories.put("ARTISTS", "artists");
        this.categories.put("CHILDCARE", "childcare");
        this.categories.put("CLASSES", "classes");
        this.categories.put("EVENTS", "events");
        this.categories.put("GENERAL", "general");
        this.categories.put("GROUPS", "groups");
        this.categories.put("LOCALNEWS", "localnews");
        this.categories.put("LOST_FOUND", "lost+found");
        this.categories.put("MISSEDCONNECTIONS", "missedconnections");
        this.categories.put("MUSICIANS", "musicians");
        this.categories.put("PETS", "pets");
        this.categories.put("POLITICS", "politics");
        this.categories.put("RANTS_RAVES", "rants&raves");
        this.categories.put("RIDESHARE", "rideshare");
        this.categories.put("VOLUNTEERS", "volunteers");
        this.categories.put("AUTOMOTIVE", "automotive");
        this.categories.put("BEAUTY", "beauty");
        this.categories.put("CELL_MOBILE", "cell/mobile");
        this.categories.put("COMPUTER", "computer");
        this.categories.put("CREATIVE", "creative");
        this.categories.put("CYCLE", "cycle");
        this.categories.put("EVENT", "event");
        this.categories.put("FARM_GARDEN", "farm+garden");
        this.categories.put("FINANCIAL", "financial");
        this.categories.put("HOUSEHOLD", "household");
        this.categories.put("LABOR_MOVE", "labor/move");
        this.categories.put("LEGAL", "legal");
        this.categories.put("LESSONS", "lessons");
        this.categories.put("MARINE", "marine");
        this.categories.put("PET", "pet");
        this.categories.put("REALESTATE", "realestate");
        this.categories.put("SKILLEDTRADE", "skilledtrade");
        this.categories.put("SMBIZADS", "smbizads");
        this.categories.put("TRAVEL_VAC", "travel/vac");
        this.categories.put("WRITE_ED_TRAN", "write/ed/tran");
        this.categories.put("ANDROID", "android");
        this.categories.put("APPLE", "apple");
        this.categories.put("ARTS", "arts");
        this.categories.put("ATHEIST", "atheist");
        this.categories.put("AUTOS", "autos");
        this.categories.put("BIKES", "bikes");
        this.categories.put("CELEBS", "celebs");
        this.categories.put("COMP", "comp");
        this.categories.put("COSMOS", "cosmos");
        this.categories.put("DIET", "diet");
        this.categories.put("DIVORCE", "divorce");
        this.categories.put("DYING", "dying");
        this.categories.put("ECO", "eco");
        this.categories.put("FEEDBK", "feedbk");
        this.categories.put("FILM", "film");
        this.categories.put("FIXIT", "fixit");
        this.categories.put("FOOD", "food");
        this.categories.put("FRUGAL", "frugal");
        this.categories.put("GAMING", "gaming");
        this.categories.put("GARDEN", "garden");
        this.categories.put("HAIKU", "haiku");
        this.categories.put("HELP", "help");
        this.categories.put("HISTORY", "history");
        this.categories.put("HOUSING", "housing");
        this.categories.put("JOBS", "jobs");
        this.categories.put("JOKES", "jokes");
        this.categories.put("LINUX", "linux");
        this.categories.put("MANNERS", "manners");
        this.categories.put("MARRIAGE", "marriage");
        this.categories.put("MONEY", "money");
        this.categories.put("MUSIC", "music");
        this.categories.put("OPEN", "open");
        this.categories.put("OUTDOOR", "outdoor");
        this.categories.put("PARENT", "parent");
        this.categories.put("PHILOS", "philos");
        this.categories.put("PHOTO", "photo");
        this.categories.put("PSYCH", "psych");
        this.categories.put("RECOVER", "recover");
        this.categories.put("RELIGION", "religion");
        this.categories.put("ROFO", "rofo");
        this.categories.put("SCIENCE", "science");
        this.categories.put("SPIRIT", "spirit");
        this.categories.put("SPORTS", "sports");
        this.categories.put("SUPER", "super");
        this.categories.put("TAX", "tax");
        this.categories.put("TRAVEL", "travel");
        this.categories.put("TV", "tv");
        this.categories.put("VEGAN", "vegan");
        this.categories.put("WORDS", "words");
        this.categories.put("WRITING", "writing");
        this.categories.put("APTS_HOUSING", "apts/housing");
        this.categories.put("HOUSINGSWAP", "housingswap");
        this.categories.put("HOUSINGWANTED", "housingwanted");
        this.categories.put("OFFICE_COMMERCIAL", "office/commercial");
        this.categories.put("PARKING_STORAGE", "parking/storage");
        this.categories.put("REALESTATEFORSALE", "realestateforsale");
        this.categories.put("ROOMS_SHARED", "rooms/shared");
        this.categories.put("ROOMSWANTED", "roomswanted");
        this.categories.put("SUBLETS_TEMPORARY", "sublets/temporary");
        this.categories.put("VACATIONRENTALS", "vacationrentals");
        this.categories.put("ANTIQUES", "antiques");
        this.categories.put("APPLIANCES", "appliances");
        this.categories.put("ARTS_CRAFTS", "arts+crafts");
        this.categories.put("ATV_UTV_SNO", "atv/utv/sno");
        this.categories.put("AUTOPARTS", "autoparts");
        this.categories.put("AVIATION", "aviation");
        this.categories.put("BABY_KID", "baby+kid");
        this.categories.put("BARTER", "barter");
        this.categories.put("BEAUTY_HLTH", "beauty+hlth");
        this.categories.put("BIKEPARTS", "bikeparts");
        this.categories.put("BOATPARTS", "boatparts");
        this.categories.put("BOATS", "boats");
        this.categories.put("BOOKS", "books");
        this.categories.put("BUSINESS", "business");
        this.categories.put("CARS_TRUCKS", "cars+trucks");
        this.categories.put("CDS_DVD_VHS", "cds/dvd/vhs");
        this.categories.put("CELLPHONES", "cellphones");
        this.categories.put("CLOTHES_ACC", "clothes+acc");
        this.categories.put("COLLECTIBLES", "collectibles");
        this.categories.put("COMPUTERPARTS", "computerparts");
        this.categories.put("COMPUTERS", "computers");
        this.categories.put("ELECTRONICS", "electronics");
        this.categories.put("FREE", "free");
        this.categories.put("FURNITURE", "furniture");
        this.categories.put("GARAGESALE", "garagesale");
        this.categories.put("HEAVYEQUIP", "heavyequip");
        this.categories.put("JEWELRY", "jewelry");
        this.categories.put("MATERIALS", "materials");
        this.categories.put("MOTORCYCLEPARTS", "motorcycleparts");
        this.categories.put("MOTORCYCLES", "motorcycles");
        this.categories.put("MUSICINSTR", "musicinstr");
        this.categories.put("PHOTO_VIDEO", "photo+video");
        this.categories.put("RVS_CAMP", "rvs+camp");
        this.categories.put("SPORTING", "sporting");
        this.categories.put("TICKETS", "tickets");
        this.categories.put("TOOLS", "tools");
        this.categories.put("TOYS_GAMES", "toys+games");
        this.categories.put("TRAILERS", "trailers");
        this.categories.put("VIDEOGAMING", "videogaming");
        this.categories.put("WANTED", "wanted");
        this.categories.put("WHEELS_TIRES", "wheels+tires");
        this.categories.put("ACCOUNTING_FINANCE", "accounting+finance");
        this.categories.put("ADMIN_OFFICE", "admin/office");
        this.categories.put("ARCH_ENGINEERING", "arch/engineering");
        this.categories.put("ART_MEDIA_DESIGN", "art/media/design");
        this.categories.put("BIOTECH_SCIENCE", "biotech/science");
        this.categories.put("BUSINESS_MGMT", "business/mgmt");
        this.categories.put("CUSTOMERSERVICE", "customerservice");
        this.categories.put("EDUCATION", "education");
        this.categories.put("ETC_MISC", "etc/misc");
        this.categories.put("FOOD_BEV_HOSP", "food/bev/hosp");
        this.categories.put("GENERALLABOR", "generallabor");
        this.categories.put("GOVERNMENT", "government");
        this.categories.put("HUMANRESOURCES", "humanresources");
        this.categories.put("LEGAL_PARALEGAL", "legal/paralegal");
        this.categories.put("MANUFACTURING", "manufacturing");
        this.categories.put("MARKETING_PR_AD", "marketing/pr/ad");
        this.categories.put("MEDICAL_HEALTH", "medical/health");
        this.categories.put("NONPROFITSECTOR", "nonprofitsector");
        this.categories.put("RETAIL_WHOLESALE", "retail/wholesale");
        this.categories.put("SALES_BIZDEV", "sales/bizdev");
        this.categories.put("SALON_SPA_FITNESS", "salon/spa/fitness");
        this.categories.put("SECURITY", "security");
        this.categories.put("SKILLEDTRADE_CRAFT", "skilledtrade/craft");
        this.categories.put("SOFTWARE_QA_DBA", "software/qa/dba");
        this.categories.put("SYSTEMS_NETWORK", "systems/network");
        this.categories.put("TECHNICALSUPPORT", "technicalsupport");
        this.categories.put("TRANSPORT", "transport");
        this.categories.put("TV_FILM_VIDEO", "tv/film/video");
        this.categories.put("WEB_INFODESIGN", "web/infodesign");
        this.categories.put("WRITING_EDITING", "writing/editing");
        this.categories.put("CREW", "crew");
        this.categories.put("DOMESTIC", "domestic");
        this.categories.put("LABOR", "labor");
        this.categories.put("TALENT", "talent");
    }

    // get category by index
    public String getCategory(int index){
        if(index < 0 || index > this.categories.size()){
            throw new IndexOutOfBoundsException();
        }
        Set<String> keys = this.categories.keySet();

        int iter = 0;
        String qKey = null;
        for(String key : keys){
            iter++;
            if(iter == index){
                qKey = key;
            }
        }
        return this.categories.get(qKey);
    }

    // get category by key
    public String getCategory(String key){
        return this.categories.get(key);
    }

    public List<String> getKeys(){
        List<String> keys = new ArrayList<>(this.categories.size());
        Set<String> keySet = this.categories.keySet();
        for(String key : keySet){
            keys.add(key);
        }
        return keys;
    }
}
