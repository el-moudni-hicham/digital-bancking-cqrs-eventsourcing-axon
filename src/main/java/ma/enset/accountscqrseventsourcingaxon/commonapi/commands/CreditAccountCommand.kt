package ma.enset.accountscqrseventsourcingaxon.commonapi.commands

import lombok.Getter

class CreditAccountCommand(id: String, amount: Double, currency: String) : BaseCommand<String>(id) {
    @Getter val amount:Double = amount
    @Getter val currency:String = currency
}

