package ma.enset.accountscqrseventsourcingaxon.commonapi.events

class AccountCreditedEvent(id:String, amount:Double, currency:String):BaseEvent<String>(id) {
    val amount:Double = amount
    val currency:String = currency
}