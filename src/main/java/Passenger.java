public class Passenger {
    private int PassengerId;
    private boolean Survived;
    private int Pclass;
    private String name;
    private boolean Sex;
    private String Age;
    private String SibSp;
    private int Parch;
    private String Ticket;
    private Double Fare;
    private String Cabin;
    private String Embarked;

    public Passenger(String lineData) {
        String[] dataItem = lineData.split(",");
        dataItem = toFixArrayStr(dataItem);
        PassengerId = Integer.valueOf(dataItem[0]);
        if(dataItem[1].equals("1")){
            Survived  = true;
        }else {
            Survived = false;
        }
        Pclass = Integer.valueOf(dataItem[2]);
        name = dataItem[3];
        if(dataItem[4] == ("male")){
            Sex = true ;
        }else {
            Sex = false;
        }
        Age = (dataItem[5]);
        SibSp = (dataItem[6]);
        Parch = Integer.valueOf(dataItem[7]);
        Ticket = (dataItem[8]);
        Fare = Double.valueOf(dataItem[9]);
        Cabin = (dataItem[10]);
        if (dataItem.length>11) {
            Embarked = (dataItem[11]);
        } else {
            Embarked = "";
        }
    }

    public  String getFormattedName(String name) {
        String fixName ;
        String lastName = " ";
        String firstName = "";
        for (int i = 0; i < name.length() - 1; i++) {
            if (name.charAt(i) != ',') {
                lastName += name.charAt(i);
            }
            else while (name.charAt(i) != '.') {
                i++;
            }
            if (name.charAt(i) == '.') {
                for (int j = i+1; j < name.length() ; j++) {
                    firstName += name.charAt(j);
                }
                break;
            }

        }
        fixName = firstName + lastName;
        return fixName ;

    }

    public String[] toFixArrayStr(String[] str){
        String[] stringsNew = new String[str.length-1];
        int counter = 0;
        for (int i = 0; i < str.length-1; i++) {
            if(i == 3){
                str[i] = getFormattedName(str[i] +","+ str[i+1]);
            }
            if(i != 4){
               stringsNew[counter] = str[i];
               counter++;
            }

        } return stringsNew;
    }

    public int getPassengerId() {
        return PassengerId;
    }

    public void setPassengerId(int passengerId) {
        PassengerId = passengerId;
    }

    public boolean isSurvived() {
        return Survived;
    }

    public void setSurvived(boolean survived) {
        Survived = survived;
    }

    public int getPclass() {
        return Pclass;
    }

    public void setPclass(int pclass) {
        Pclass = pclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean sex) {
        Sex = sex;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getSibSp() {
        return SibSp;
    }

    public void setSibSp(String sibSp) {
        SibSp = sibSp;
    }

    public int getParch() {
        return Parch;
    }

    public void setParch(int parch) {
        Parch = parch;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public Double getFare() {
        return Fare;
    }

    public void setFare(Double fare) {
        Fare = fare;
    }

    public String getCabin() {
        return Cabin;
    }

    public void setCabin(String cabin) {
        Cabin = cabin;
    }

    public String getEmbarked() {
        return Embarked;
    }

    public void setEmbarked(String embarked) {
        Embarked = embarked;
    }
}
