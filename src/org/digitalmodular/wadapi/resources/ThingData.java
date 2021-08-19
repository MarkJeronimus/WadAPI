package org.digitalmodular.wadapi.resources;

import org.digitalmodular.utilities.NumberUtilities;
import org.digitalmodular.utilities.ValidatorUtilities;
import static org.digitalmodular.utilities.ValidatorUtilities.requireNonNull;

/**
 * @author Zom-B
 */
// Created 2021-08-18
public class ThingData {
	private final String  title;
	private final String  sprite;
	private final int     color;
	private final float   alpha;
	private final String  renderStyle;
	private final int     arrow;
	private final int     radius;
	private final int     height;
	private final int     hangs;
	private final int     blocking;
	private final int     errorCheck;
	private final boolean fixedSize;
	private final boolean fixedRotation;
	private final boolean absoluteZ;
	private final float   spriteScale;
	private final boolean lockSprite;
	private final String  decorateClass;
	private final int     thingLink;
	private final boolean optional;

	public ThingData(String title,
	                 String sprite,
	                 int color,
	                 float alpha,
	                 String renderStyle,
	                 int arrow,
	                 int radius,
	                 int height,
	                 int hangs,
	                 int blocking,
	                 int errorCheck,
	                 boolean fixedSize,
	                 boolean fixedRotation,
	                 boolean absoluteZ,
	                 float spriteScale,
	                 boolean lockSprite,
	                 String decorateClass,
	                 int thingLink,
	                 boolean optional) {
		this.title = ValidatorUtilities.requireStringLengthAtLeast(1, title, "title");
		this.sprite = sprite == null ? "" : sprite;
		this.color = Math.max(0, color);
		this.alpha = NumberUtilities.clamp(0.0f, 1.0f, alpha);
		this.renderStyle = requireNonNull(renderStyle, "renderStyle").toLowerCase();
		this.arrow = Math.max(0, arrow);
		this.radius = radius < 4 ? 8 : radius;
		this.height = Math.max(0, height);
		this.hangs = Math.max(0, hangs);
		this.blocking = Math.max(0, blocking);
		this.errorCheck = Math.max(0, errorCheck);
		this.fixedSize = fixedSize;
		this.fixedRotation = fixedRotation;
		this.absoluteZ = absoluteZ;
		this.spriteScale = Math.max(0, spriteScale);
		this.lockSprite = lockSprite;
		this.decorateClass = requireNonNull(decorateClass, "decorateClass");
		this.thingLink = Math.max(0, thingLink);
		this.optional = optional;
	}

	public String getTitle() {
		return title;
	}

	public String getSprite() {
		return sprite;
	}

	public int getColor() {
		return color;
	}

	public float getAlpha() {
		return alpha;
	}

	public String getRenderStyle() {
		return renderStyle;
	}

	public int getArrow() {
		return arrow;
	}

	public int getRadius() {
		return radius;
	}

	public int getHeight() {
		return height;
	}

	public int getHangs() {
		return hangs;
	}

	public int getBlocking() {
		return blocking;
	}

	public int getErrorCheck() {
		return errorCheck;
	}

	public boolean isFixedSize() {
		return fixedSize;
	}

	public boolean isFixedRotation() {
		return fixedRotation;
	}

	public boolean isAbsoluteZ() {
		return absoluteZ;
	}

	public float getSpriteScale() {
		return spriteScale;
	}

	public boolean isLockSprite() {
		return lockSprite;
	}

	public String getDecorateClass() {
		return decorateClass;
	}

	public int getThingLink() {
		return thingLink;
	}

	/**
	 * Optional thing is a thing that can have nonexistent sprite. This is currently only used for Skulltag things
	 */
	public boolean isOptional() {
		return optional;
	}
}
