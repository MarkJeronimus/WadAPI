package org.digitalmodular.wadapi;

import java.awt.Color;

import org.jetbrains.annotations.Nullable;

/**
 * @author Zom-B
 */
// Created 2011-08-14
@Deprecated
public class ThingData {
	private final           int       id;
	private final           ThingType thingType;
	private final           int       naturalOrder;
	private final           String    name;
	private final           int       diameter;
	private final           int       height;
	private final           boolean   hasDirection;
	private final           boolean   hangs;
	private final           boolean   blocking;
	private final @Nullable String    sprite;
	private final           Color     color;

	public ThingData(int id,
	                 ThingType thingType,
	                 int naturalOrder,
	                 String name,
	                 int diameter,
	                 int height,
	                 boolean hasDirection,
	                 boolean hangs,
	                 boolean blocking,
	                 @Nullable String sprite,
	                 int colorIndex) {
		this.id = id;
		this.thingType = thingType;
		this.naturalOrder = naturalOrder;
		this.name = name;
		this.diameter = diameter;
		this.height = height;
		this.hasDirection = hasDirection;
		this.hangs = hangs;
		this.blocking = blocking;
		this.sprite = sprite;
		color = ThingConstants.COLORS[colorIndex];
	}

	public int getId() {
		return id;
	}

	public ThingType getThingType() {
		return thingType;
	}

	public int getNaturalOrder() {
		return naturalOrder;
	}

	public String getName() {
		return name;
	}

	public int getDiameter() {
		return diameter;
	}

	public int getHeight() {
		return height;
	}

	public boolean isHasDirection() {
		return hasDirection;
	}

	public boolean isHangs() {
		return hangs;
	}

	public boolean isBlocking() {
		return blocking;
	}

	public @Nullable String getSprite() {
		return sprite;
	}

	public Color getColor() {
		return color;
	}
}
