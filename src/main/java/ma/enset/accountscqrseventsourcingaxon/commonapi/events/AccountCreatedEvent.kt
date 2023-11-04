package ma.enset.accountscqrseventsourcingaxon.commonapi.events

import ma.enset.accountscqrseventsourcingaxon.commonapi.enums.AccountStatus

class AccountCreatedEvent(id: String, balance: Double, currency: String, status: AccountStatus) : BaseEvent<String>(id) {
    val balance: Double = balance
    val currency: String = currency
    val status: AccountStatus = status
}
