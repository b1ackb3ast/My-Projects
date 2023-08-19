let xp = 0;
let health = 100;
let gold = 50;
let currentWeapon = 0;
let monsterHealth;
let inventory = ["stick"];
let fighting = 0;

// constant definitions
const button1 = document.querySelector("#button1");
const button2 = document.querySelector("#button2");
const button3 = document.querySelector("#button3");
const text = document.querySelector("#text");
const xpText = document.querySelector("#xpText");
const healthText = document.querySelector("#healthText");
const goldText = document.querySelector("#goldText");
const monsterStats = document.querySelector("#monsterStats");
const monsterNameText = document.querySelector("#monsterName");
const monsterHealthText = document.querySelector("#monsterHealth");

const weapons = [
  {
    name: "stick",
    power: 5,
  },
  {
    name: "dagger",
    power: 30,
  },
  {
    name: "claw hammer",
    power: 50,
  },
  {
    name: "sword",
    power: 100,
  },
];

const monsters = [

  {
    name: "slime",
    level: 2,
    health:15

  },
  {
    name: "fanged beast",
    level: 8,
    health:60

  },
  {
    name: "dragon",
    level: 20,
    health:300

  },




]

const locations = [
  {
    name: "town square",
    "button text": ["Go to store", "Go to cave", "Fight dragon"],
    "button functions": [goStore, goCave, fightDragon],
    text: 'You are in the town square. You see a sign that says"store"',
  },
  {
    name: "store",
    "button text": [
      "Buy 10 health (10 gold)",
      "Buy weapon (30 gold)",
      "Go to town square",
    ],
    "button functions": [buyHealth, buyWeapon, goTown],
    text: "You enter the store",
  },
  {
    name: "cave",
    "button text": ["Fight slime", "Fight fanged beast", "Go to town square"],
    "button functions": [fightSlime, fightBeast, goTown],
    text: "You enter the cave. You see some monsters.",
  },
  {
    name: "fight",
    "button text": ["Attack", "Dodge", "Run"],
    "button functions": [attack, dodge, goTown],
    text: "You are fighting a monster",
  },
  {
    name: "kill monster",
    "button text": ["Go to town square", "Go to town square", "Go to town square"],
    "button functions": [goTown, goTown, goTown],
    text: "The monster screams 'Arg!' as it dies. You gain experience points and find gold.",
  },
  {
    name: "lose",
    "button text": ["REPLAY?", "REPLAY?", "REPLAY?"],
    "button functions": [restart, restart, restart],
    text: "You die.",
  },
  {
    name: "win",
    "button text": ["REPLAY?", "REPLAY?", "REPLAY?"],
    "button functions": [restart, restart, restart],
    text: "You defeat the dragon. YOU WIN THE GAME!",
  },
];

// initialize buttons

button1.onclick = goStore;
button2.onclick = goCave;
button3.onclick = fightDragon;

function update(location) {
  monsterStats.style.display = "none";
  button1.innerText = location["button text"][0];
  button2.innerText = location["button text"][1];
  button3.innerText = location["button text"][2];
  button1.onclick = location["button functions"][0];
  button2.onclick = location["button functions"][1];
  button3.onclick = location["button functions"][2];
  // dot notation only works if the key is a single word
  text.innerText = location.text;
}

function goTown() {
  update(locations[0]);
}

function goStore() {
  update(locations[1]);
}
function goCave() {
  update(locations[2]);
}


function buyHealth() {
  if (gold >= 10) {
    gold = gold - 10;
    health = health + 10;
    goldText.innerText = gold;
    healthText.innerText = health;
    text.innerText = "You bought 10 health.";
  } else {
    text.innerText = "You do not have enough gold to buy health.";
  }
}
// current weapon contains the number of weapons in the inventory
function buyWeapon() {
  if (currentWeapon < weapons.length -1) {
    // for weapon upgrade
    if (gold >= 30) {
      gold -= 30;
      currentWeapon += 1;
      goldText.innerText = gold;
      healthText.innerText = health;
      let newWeapon = weapons[currentWeapon].name;
      text.innerText = "You now have a " + newWeapon + ".";
      inventory.push(newWeapon);
      text.innerText += "In your inventory you have: " + inventory;
    } else {
      text.innertext = "You do not have enough gold to buy a weapon.";
    }

  } else {
    text.innerText = "You already have the most powerful weapon!";
    button2.innerText = "Sell weapon for 15 gold";
    button2.onclick = sellWeapon;
  }
  
}

function sellWeapon() {
  // players should not be able to sell if it is their only weapon
  if (inventory.length > 1) {
    gold+=15;
    goldText.innerText = gold;
    // new version of currentWeapon is only scoped within the if statement
    // shift removing the first element from array and returning it to this variable
    let currentWeapon = inventory.shift();
    text.innerText = "You sold a " + currentWeapon + ".";
    text.innerText += " In your inventory you have: " + inventory;

  } else {
    text.innerText = "Don't sell your only weapon.";
  }
}

// monster fighting functions
function fightSlime() {
  fighting = 0;
  goFight();
}

function fightBeast() {
  fighting = 1;
  goFight();

}

function fightDragon() {
  fighting = 2;
  goFight();
}



function goFight() {
  update(locations[3]);
  monsterHealth = monsters[fighting].health;
  monsterStats.style.display = "block";
  monsterNameText.innerText = monsters[fighting].name;
  monsterHealthText.innerText = monsterHealth;
}

function attack() {
  text.innerText = "The " + monsters[fighting].name + " attacks. ";
  text.innerText += "You attack it with your " + weapons[currentWeapon].name + ".";
  // if player does not miss the attack
  if (isMonsterHit()) {
    health -= getMonsterAttackValue(monsters[fighting].level);
  } else {
    text.innerText += "You miss.";
  }
  
  monsterHealth -= weapons[currentWeapon].power + Math.floor(Math.random() * xp) + 1;
  healthText.innerText = health;
  monsterHealthText.innerText = monsterHealth;
  if (health <=0) {
    lose();
  } else if (monsterHealth <= 0) {
    if (fighting == 2) {
      winGame();
    } else {
    defeatMonster();
    }
    // weapon might break during attack
    if (Math.random() <=.1 && inventory.length !== 1) {
      text.innerText = "Your " + inventory.pop() + " breaks.";
      currentWeapon--;
    }
  }


}
function dodge() {
  text.innerText = "You dodge the attack from the "  + monsters[fighting].name + ".";

}

function defeatMonster() {
  gold += Math.floor(monsters[fighting].level) * 6.7;
  xp += monsters[fighting].level;
  goldText.innerText = gold;
  xpText.innerText = xp;
  update(locations[4])

}
function lose() {
  update(locations[5]);

}

function winGame() {
  update(location[6]);
}
function restart() {
  xp = 0;
  health = 500;
  gold = 50;
  currentWeapon = 0;
  inventory = ["stick"];
  goldText.innerText = gold;
  healthText.innerText = health;
  xpText.innerText = xp;
  goTown();
}

function getMonsterAttackValue(level) {
  let hit = (level * 5) - (Math.floor(Math.random() * xp));
  return hit;

}

function isMonsterHit() {
  return Math.random() > .2 || health < 20;
}

function dodge() {
  text.innerText = "You dodge the attack from the " + monsters[fighting].name + ".";
}