package teamroots.embers.power;

import teamroots.embers.entity.EntityEmberPacket;

public interface IEmberPacketReceiver {
    boolean isFull();

    boolean onReceive(EntityEmberPacket packet);
}
