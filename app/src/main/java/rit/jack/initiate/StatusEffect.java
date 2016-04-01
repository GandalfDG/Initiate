package rit.jack.initiate;

/**
 * The StatusEffect class contains the information for a status effect that might be applied to
 * a character. The effect may last a certain number of combat rounds, or it may be indeterminate.
 * Created by Jack on 4/1/2016.
 */
public class StatusEffect {
    private String effectName;
    private String effectDescription; //what the effect does
    private int duration; //number of rounds the effect lasts
    //true if the effect lasts for the entire duration of combat or an indeterminate number of rounds
    private boolean permanent;

    public StatusEffect(String effectName, String effectDescription, int duration, boolean permanent) {
        this.effectName = effectName;
        this.effectDescription = effectDescription;
        this.duration = duration;
        this.permanent = permanent;
    }

    public StatusEffect(String effectName, int duration, boolean permanent) {
        this.effectName = effectName;
        this.duration = duration;
        this.permanent = permanent;
    }

    public String getEffectName() {
        return effectName;
    }

    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    public String getEffectDescription() {
        return effectDescription;
    }

    public void setEffectDescription(String effectDescription) {
        this.effectDescription = effectDescription;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }
}
