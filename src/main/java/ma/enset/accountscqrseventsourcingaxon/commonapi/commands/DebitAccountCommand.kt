package ma.enset.accountscqrseventsourcingaxon.commonapi.commands

class DebitAccountCommand(id:String, amount:Double, currency:String):BaseCommand<String>(id) {
    val amount:Double = amount
    val currency:String = currency
}