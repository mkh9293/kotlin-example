package chapter17

class Barrel<in T>(item: T)

fun main() {
    var fedoraBarrel : Barrel<Fedora> = Barrel(Fedora("평범한 중절모", 15))
    var lootBarrel : Barrel<Loot> = Barrel(Coin(15))

//    lootBarrel = fedoraBarrel
    fedoraBarrel = lootBarrel
//    var myFedora: Fedora = lootBarrel.item
}