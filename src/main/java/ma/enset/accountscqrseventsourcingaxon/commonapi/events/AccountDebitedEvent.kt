package ma.enset.accountscqrseventsourcingaxon.commonapi.events

class AccountDebitedEvent(id:String, amount:Double, currency:String):BaseEvent<String>(id) {
    val amount:Double = amount
    val currency:String = currency
}