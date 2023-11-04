package ma.enset.accountscqrseventsourcingaxon.commonapi.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<T> {
    @TargetAggregateIdentifier // id of aggregate "Account" <-- Command
    @Getter T id;
    public BaseCommand(T id) {
        this.id = id;
    }
}
