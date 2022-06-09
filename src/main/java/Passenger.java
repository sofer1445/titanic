public class Passenger {
    private int passengerId;
    private boolean survived;
    private int pclass;
    private String name;
    private boolean sex;
    private String age;
    private String sibSp;
    private int parch;
    private String ticket;
    private Double fare;
    private String cabin;
    private String embarked;

    public Passenger(String lineData) {
        String[] dataItem = lineData.split(",");
        dataItem = toFixArrayStr(dataItem);
        passengerId = Integer.valueOf(dataItem[0]);
        if(dataItem[1].equals("1")){
            survived = true;
        }else {
            survived = false;
        }
        pclass = Integer.valueOf(dataItem[2]);
        name = dataItem[3];
        if(dataItem[4] == ("male")){
            sex = true ;
        }else {
            sex = false;
        }
        age = (dataItem[5]);
        sibSp = (dataItem[6]);
        parch = Integer.valueOf(dataItem[7]);
        ticket = (dataItem[8]);
        fare = Double.valueOf(dataItem[9]);
        cabin = (dataItem[10]);
        if (dataItem.length>11) {
            embarked = (dataItem[11]);
        } else {
            embarked = "";
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
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        if (passengerId > 0 && passengerId < 892) {
            this.passengerId = passengerId;
        } else {
            this.passengerId = 0;
        }
    }
    public boolean isSurvived() {
        return survived;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    public int getPclass() {
        return pclass;
    }

    public void setPclass(int pclass) {
        pclass = pclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSibSp() {
        return sibSp;
    }

    public void setSibSp(String sibSp) {
        this.sibSp = sibSp;
    }

    public int getParch() {
        return parch;
    }

    public void setParch(int parch) {
        this.parch = parch;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        if (fare < 93.5 && fare >= 0) {
            this.fare = fare;
        }else {
            this.fare = -1.0;
        }
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "PassengerId=" + passengerId +
                ", survived=" + survived +
                ", pclass=" + pclass +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age='" + age + '\'' +
                ", sibSp='" + sibSp + '\'' +
                ", parch=" + parch +
                ", ticket='" + ticket + '\'' +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarked='" + embarked + '\'' +
                '}';
    }
}
