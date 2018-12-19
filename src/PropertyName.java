public enum PropertyName {
  CATEGORY,CONTEXT,STARTYEAR,STARTMONTH,STARTDATE,STARTWEEK,STARTHOUR,STARTMINUTE,WHETHER,
  FINISHYEAR,FINISHMONTH,FINISHDATE,FINISHHOUR,FINISHMINUTE,FINISHWEEK,FINISH;
  
  public String toString(){
    switch(this){
     case CATEGORY:
       return "category";
     case CONTEXT:
       return "context";
     case STARTYEAR:
       return "startYear";
     case STARTMONTH:
         return "startMonth";
     case STARTDATE:
           return "startDate";
     case STARTWEEK:
       return "startWeek";
     case STARTHOUR:
       return "startHour";
     case STARTMINUTE:
         return "startMinute";
     case WHETHER:
       return "whether";
     case FINISHYEAR:
       return "finishYear";
     case FINISHMONTH:
       return "finishMonth";
     case FINISHDATE:
       return "finishDate";
     case FINISHWEEK:
       return "finishWeek";
     case FINISHHOUR:
         return "finishHour";
     case FINISHMINUTE:
         return "finishMinute";
     case FINISH:
       return "finish";
     default:
       System.out.println("Enumにありません");
       return null;
    }
  } 
}