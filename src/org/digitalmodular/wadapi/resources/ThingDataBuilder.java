package org.digitalmodular.wadapi.resources;

import org.digitalmodular.utilities.NumberUtilities;
import static org.digitalmodular.utilities.ValidatorUtilities.requireAtLeast;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;
import static org.digitalmodular.utilities.ValidatorUtilities.requireStringLengthAtLeast;

/**
 * @author Zom-B
 */
// Created 2021-08-18
public class ThingDataBuilder {
	private String  sprite        = "";
	private int     color         = 0;
	private float   alpha         = 1.0f;
	private String  renderStyle   = "normal";
	private boolean arrow         = false;
	private int     radius        = 10;
	private int     height        = 20;
	private int     hangs         = 0;
	private int     blocking      = 0;
	private int     errorCheck    = 1;
	private boolean fixedSize     = false;
	private boolean fixedRotation = false;
	private boolean absoluteZ     = false;
	private float   spriteScale   = 1.0f;
	private boolean lockSprite    = false;
	private String  decorateClass = "";
	private int     thingLink     = 0;
	private boolean optional      = false;

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

	public ThingData build(int id, String category, String title) {
		requireAtLeast(0, id, "id");
		requireStringLengthAtLeast(1, category, "category");
		requireStringLengthAtLeast(1, title, "title");

		return new ThingData(id,
		                     category,
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
	}
}
