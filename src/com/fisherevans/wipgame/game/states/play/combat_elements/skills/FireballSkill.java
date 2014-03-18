package com.fisherevans.wipgame.game.states.play.combat_elements.skills;

import com.fisherevans.eventRouter.EventAction;
import com.fisherevans.eventRouter.EventRouter;
import com.fisherevans.wipgame.game.states.play.Direction;
import com.fisherevans.wipgame.game.states.play.PlayState;
import com.fisherevans.wipgame.game.states.play.characters.GameCharacter;
import com.fisherevans.wipgame.game.states.play.combat_elements.Skill;
import com.fisherevans.wipgame.game.states.play.entities.Bomb;
import com.fisherevans.wipgame.game.states.play.entities.Fireball;

/**
 * Author: Fisher Evans
 * Date: 3/3/14
 */
public class FireballSkill extends Skill {
    public static final float USAGE_COST = 0.15f;
    public static final float REGEN_RATE = 0.25f;

    public FireballSkill(GameCharacter owner) {
        super(USAGE_COST, REGEN_RATE, 0.4f, owner);
        EventRouter.subscribe(this, "play");
    }

    @EventAction(1)
    @Override
    public boolean executeSkill() {
        float dir = getOwner().getDirection() == Direction.Right ? 1f : -1f;
        Fireball fireball = new Fireball(getOwner().getBody().getCenterX() + dir*0.3f, getOwner().getBody().getCenterY()+0.11f, dir*15f, -10f, getOwner());
        PlayState.current.addGameObject(fireball);
        return true;
    }
}