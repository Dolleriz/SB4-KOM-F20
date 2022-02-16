package dk.sdu.mmmi.cbse.common.data;

import dk.sdu.mmmi.cbse.common.data.entityparts.EntityPart;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Entity implements Serializable {

    private final UUID ID = UUID.randomUUID();

    private float[] shapeX = new float[4];
    private float[] shapeY = new float[4];
    private float[] flameX = new float[3];
    private float[] flameY = new float[3];
    private float[] enemyX = new float[6];
    private float[] enemyY = new float[6];
    private float radius;
    private float boundingCircleX;
    private float boundingCircleY;

    private Map<Class, EntityPart> parts;

    public Entity() {
        parts = new ConcurrentHashMap<>();

    }

    public void add(EntityPart part) {
        parts.put(part.getClass(), part);
    }

    public void remove(Class partClass) {
        parts.remove(partClass);
    }

    public <E extends EntityPart> E getPart(Class partClass) {
        return (E) parts.get(partClass);
    }

    public void setRadius(float r) {
        this.radius = r;
    }

    public float getRadius() {
        return radius;
    }

    public String getID() {
        return ID.toString();
    }

    public float[] getShapeX() {
        return shapeX;
    }

    public void setShapeX(float[] shapeX) {
        this.shapeX = shapeX;
    }

    public float[] getShapeY() {
        return shapeY;
    }

    public void setShapeY(float[] shapeY) {
        this.shapeY = shapeY;
    }

    public float[] getFlameX() {
        return flameX;
    }

    public void setFlameX(float[] flameX) {
        this.flameX = flameX;
    }

    public float[] getFlameY() {
        return flameY;
    }

    public void setFlameY(float[] flameY) {
        this.flameY = flameY;
    }

    public float[] getEnemyX() {
        return enemyX;
    }

    public void setEnemyX(float[] enemyX) {
        this.enemyX = enemyX;
    }

    public float[] getEnemyY() {
        return enemyY;
    }

    public void setEnemyY(float[] enemyY) {
        this.enemyY = enemyY;
    }

    public float getBoundingCircleX() {
        return boundingCircleX;
    }

    public void setBoundingCircleX(float boundingCircleX) {
        this.boundingCircleX = boundingCircleX;
    }

    public float getBoundingCircleY() {
        return boundingCircleY;
    }

    public void setBoundingCircleY(float boundingCircleY) {
        this.boundingCircleY = boundingCircleY;
    }
    
    
    public boolean checkCollision(Entity entity) {
        float dx = this.boundingCircleX - entity.boundingCircleX;
        float dy = this.boundingCircleY - entity.boundingCircleY;
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        if (distance < this.radius + entity.radius) {
            return true;
        }
        return false;
    }

}
