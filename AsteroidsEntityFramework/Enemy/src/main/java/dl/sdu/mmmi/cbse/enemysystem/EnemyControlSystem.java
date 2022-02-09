package dl.sdu.mmmi.cbse.enemysystem;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.LEFT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.RIGHT;
import static dk.sdu.mmmi.cbse.common.data.GameKeys.UP;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class EnemyControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity enemy : world.getEntities(Enemy.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);

            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);

            updateShape(enemy);
        }
    }

    private void updateShape(Entity entity) {
        float[] enemyX = entity.getEnemyX();
        float[] enemyY = entity.getEnemyY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();

        enemyX[0] = x - 10;
        enemyY[0] = y;

        enemyX[1] = x - 3;
        enemyY[1] = y - 5;

        enemyX[2] = x + 3;
        enemyY[2] = y - 5;

        enemyX[3] = x + 10;
        enemyY[3] = y;

        enemyX[4] = x + 3;
        enemyY[4] = y + 5;

        enemyX[5] = x - 3;
        enemyY[5] = y + 5;

        entity.setShapeX(enemyX);
        entity.setShapeY(enemyY);
    }

}
