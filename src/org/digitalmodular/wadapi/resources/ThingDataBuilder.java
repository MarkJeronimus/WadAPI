package org.digitalmodular.wadapi.resources;

import org.jetbrains.annotations.Nullable;

import org.digitalmodular.utilities.NumberUtilities;
import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;
import static org.digitalmodular.utilities.ValidatorUtilities.requireStringLengthAtLeast;

/**
 * @author Zom-B
 */
// Created 2021-08-18
public class ThingDataBuilder {
	private @Nullable Integer id;
	private @Nullable String  categoryName;
	private           String  sprite;
	private           int     color;
	private           float   alpha;
	private           String  renderStyle;
	private           boolean arrow;
	private           int     radius;
	private           int     height;
	private           int     hangs;
	private           int     blocking;
	private           int     errorCheck;
	private           boolean fixedSize;
	private           boolean fixedRotation;
	private           boolean absoluteZ;
	private           float   spriteScale;
	private           boolean lockSprite;
	private           String  decorateClass;
	private           int     thingLink;
	private           boolean optional;

	public ThingDataBuilder() {
		resetAll();
	}

	private void resetThing() {
		id = null;
		categoryName = null;
	}

	public void resetAll() {
		sprite = "";
		color = 0;
		alpha = 1.0f;
		renderStyle = "normal";
		arrow = false;
		radius = 10;
		height = 20;
		hangs = 0;
		blocking = 0;
		errorCheck = 1;
		fixedSize = false;
		fixedRotation = false;
		absoluteZ = false;
		spriteScale = 1.0f;
		lockSprite = false;
		decorateClass = "";
		thingLink = 0;
		optional = false;
	}

	public void setId(Integer id) {
		this.id = requireAtLeast(0, id, "id");
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = requireStringLengthAtLeast(1, categoryName, "categoryName");
	}

	public void setSprite(String sprite) {
		this.sprite = sprite == null ? "" : sprite;
	}

	public void setColor(int color) {
		this.color = Math.max(0, color);
	}

	public void setAlpha(float alpha) {
		this.alpha = NumberUtilities.clamp(0.0f, 1.0f, alpha);
	}

	public void setRenderStyle(String renderStyle) {
		this.renderStyle = requireNonNull(renderStyle, "renderStyle").toLowerCase();
	}

	public void setArrow(int arrow) {
		if (arrow == 0)
			this.arrow = false;
		else if (arrow == 1)
			this.arrow = true;
		else
			throw new IllegalArgumentException("Not a valid 'arrow' value: " + arrow);
	}

	public void setRadius(int radius) {
		this.radius = radius < 4 ? 8 : radius;
	}

	public void setHeight(int height) {
		this.height = Math.max(0, height);
	}

	public void setHangs(int hangs) {
		this.hangs = Math.max(0, hangs);
	}

	public void setBlocking(int blocking) {
		this.blocking = Math.max(0, blocking);
	}

	public void setErrorCheck(int errorCheck) {
		this.errorCheck = Math.max(0, errorCheck);
	}

	public void setFixedSize(boolean fixedSize) {
		this.fixedSize = fixedSize;
	}

	public void setFixedRotation(boolean fixedRotation) {
		this.fixedRotation = fixedRotation;
	}

	public void setAbsoluteZ(boolean absoluteZ) {
		this.absoluteZ = absoluteZ;
	}

	public void setSpriteScale(float spriteScale) {
		this.spriteScale = Math.max(0, spriteScale);
	}

	public void setLockSprite(boolean lockSprite) {
		this.lockSprite = lockSprite;
	}

	public void setDecorateClass(String decorateClass) {
		this.decorateClass = requireNonNull(decorateClass, "decorateClass");
	}

	public void setThingLink(int thingLink) {
		this.thingLink = Math.max(0, thingLink);
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	public ThingData build(String title) {
		if (id == null)
			throw new IllegalStateException("'id' not set yet");
		if (categoryName == null)
			throw new IllegalStateException("'categoryName' not set yet: " + id);

		requireStringLengthAtLeast(1, title, "title");

		ThingData thingData = new ThingData(id,
		                                    categoryName,
		                                    title,
		                                    sprite,
		                                    color,
		                                    alpha,
		                                    renderStyle,
		                                    arrow,
		                                    radius,
		                                    height,
		                                    hangs,
		                                    blocking,
		                                    errorCheck,
		                                    fixedSize,
		                                    fixedRotation,
		                                    absoluteZ,
		                                    spriteScale,
		                                    lockSprite,
		                                    decorateClass,
		                                    thingLink,
		                                    optional);

		resetThing();

		return thingData;
	}
}
