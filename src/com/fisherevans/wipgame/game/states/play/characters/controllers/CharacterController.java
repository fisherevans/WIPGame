package com.fisherevans.wipgame.game.states.play.characters.controllers;


import com.fisherevans.fizzics.components.Rectangle;
import com.fisherevans.fizzics.components.Side;
import com.fisherevans.fizzics.listeners.CollisionListener;
import com.fisherevans.wipgame.game.states.play.characters.*;
import com.fisherevans.wipgame.game.states.play.characters.Character;
import com.fisherevans.wipgame.input.InputsListener;
import com.fisherevans.wipgame.input.Key;
import com.fisherevans.wipgame.resources.Inputs;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Fisher Evans
 * Date: 2/11/14
 */
public abstract class CharacterController implements InputsListener, CollisionListener {
    private int _inputSource;
    private com.fisherevans.wipgame.game.states.play.characters.Character _character;

    protected CharacterController(Character character, int inputSource) {
        _character = character;
        _inputSource = inputSource;

        _character.getBody().addCollisionListener(this);
    }

    public abstract void update(float delta);

    @Override
    public void keyDown(Key key, int inputSource) {
        if(_inputSource == inputSource) {
            down(key);
        }
    }

    @Override
    public void keyUp(Key key, int inputSource) {
        if(_inputSource == inputSource) {
            up(key);
        }
    }

    public abstract void up(Key key);

    public abstract void down(Key key);

    public Character getCharacter() {
        return _character;
    }

    public boolean state(Key key) {
        return Inputs.keyState(key, _inputSource);
    }

    @Override
    public void collision(Rectangle rectangle, Rectangle rectangle2, Side side) {
    }
}