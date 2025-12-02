import java.util.ArrayList;

public class Team {
    ArrayList<Character> members;

    public Team(ArrayList<Character> members) {
        this.members = members;
    }

    public Character getMembers(int pos) {
        return members.get(pos);
    }

    public int getPosition(Character member) {
        return members.indexOf(member);
    }

    public void addMember(Character member, int pos) {
        members.add(pos, member);
    }
}
