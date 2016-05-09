package kz.theeurasia.policy.domain;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageContent {

    private BufferedImage image;

    public ImageContent() {
    }

    public ImageContent(byte[] content) {
	setContent(content);
    }

    public ImageContent(BufferedImage image) {
	this.image = image;
    }

    public void setContent(byte[] content) {
	try (InputStream in = new ByteArrayInputStream(content)) {
	    image = ImageIO.read(in);
	} catch (IOException ignored) {
	}
    }

    public byte[] getContent() {
	if (image != null) {
	    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
		ImageIO.write(image, "png", baos);
		return baos.toByteArray();
	    } catch (IOException ignored) {
	    }
	}
	return null;
    }

    public int getImageType() {
	if (image != null)
	    return image.getType();
	return 0;
    }

    public int getWidth() {
	if (image != null)
	    return image.getWidth();
	return 0;
    }

    public int getHeight() {
	if (image != null)
	    return image.getHeight();
	return 0;
    }

    public static enum ResizeMode {
	BY_HEIGHT, BY_WIDTH;
    }

    public static ImageContent resizeImageContent(ImageContent origin, int newWidth, int newHeihght) {
	ImageContent ret = new ImageContent();
	ret.image = new BufferedImage(newWidth, newHeihght, origin.getImageType());
	Graphics2D g = ret.image.createGraphics();
	g.drawImage(origin.image, 0, 0, ret.image.getWidth(), ret.image.getHeight(), null);
	g.dispose();
	g.setComposite(AlphaComposite.Src);
	g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	return ret;
    }

    public static ImageContent resizeImageContent(ImageContent origin, int resizeTo, ResizeMode resizeMode) {
	switch (resizeMode) {
	case BY_WIDTH:
	    return resizeImageContent(origin, resizeTo, origin.getHeight() * resizeTo / origin.getWidth());
	case BY_HEIGHT:
	default:
	    return resizeImageContent(origin, origin.getWidth() * resizeTo / origin.getHeight(), resizeTo);
	}
    }
}
