import javax.swing.*;

public class Passenger {
    private int passengerId;
    private boolean survived;
    private int pclass;
    private String name;
    private String sex;
    private String age;
    private String sibSp;
    private String parch;
    private String ticket;
    private Double fare;
    private String cabin;
    private String embarked;

    public Passenger(String lineData) {
//        String original = lineData;
//        System.out.println(original);
        String[] dataItem = lineData.split(",");
        dataItem = toFixArrayStr(dataItem);
        passengerId = Integer.parseInt(dataItem[0]);
        switch (dataItem[1]){
            case "1":
                survived = true;
                break;
            case "0":
                survived = false;

        }
//        survived = dataItem[1].equals("1");
        pclass = Integer.parseInt(dataItem[2]);
        name = dataItem[3];
        sex = dataItem[4];
//        if (dataItem[4].equals("male")) {
//            sex = "male";
//        }
//        if (dataItem[4].equals("female")) {
//            sex = "female";
//        }
        age = (dataItem[5]);
        sibSp = dataItem[6];
        parch = dataItem[7];
        ticket = (dataItem[8]);
        fare = Double.parseDouble(dataItem[9]);
        if(dataItem[10] == null){
            cabin = "";
        }else {
            cabin = (dataItem[10]);
        }
        if (dataItem.length < 12 ) {
            this.embarked = "";
        } else {
            this.embarked = (dataItem[11]);
        }

    }
    public  String getFormattedName(String name) {
        String fixName;
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
        for (int i = 0; i < str.length; i++) {
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
        this.pclass = pclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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

    public void setSibSp(int sibSp) {
        this.sibSp = String.valueOf(sibSp);
    }

    public String getParch() {
        return parch;
    }

    public void setParch(int parch) {
        this.parch = String.valueOf(parch);
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



    public String toString() {
        return "" +
                 passengerId +
                "," + survived +
                "," + pclass +
                "," + name + '\'' +
                "," + sex +
                "," + age + '\'' +
                "," + sibSp + '\'' +
                "," + parch +
                ",'" + ticket + '\'' +
                "," + fare +
                "," + cabin + '\'' +
                embarked;
    }

}
