import random

cpu_score = 0
player_score = 0


def main():
    while True:
        global player_score, cpu_score

        computer = get_computer_choice()
        player = get_user_choice()

        if(check_if_invalid_option(player)):
            print(f"Error! {player} is an invalid option.")
            continue;

        results = play(computer,player)

        print(results)
    

        if(player_score == 3 or cpu_score == 3):
            print("\nFinal Scores:")
            print(f"Computer: {cpu_score}")
            print(f"Player: {player_score}")
            break


def get_computer_choice():
    choices = ["Rock", "Paper", "scissors"]
    return random.choice(choices).lower()

def get_user_choice():
        player = input("rock, paper, or scissors?").strip().lower()
        return player
        

def check_if_invalid_option(player):
    if player not in ["rock", "paper", "scissors"]:
        return True
    return False


def check_if_a_tie(computer, player):
    if computer == player:
        return True
    return False


def check_if_player_wins(computer, player):
    if (computer == "rock" and player == "scissors") or \
       (computer == "paper" and player == "rock") or \
       (computer == "scissors" and player == "paper"):
        return False
    return True
        

def play(computer, player):
    global player_score, cpu_score

    if check_if_a_tie(computer, player):
        return "The round was a tie!:"
    elif check_if_player_wins(computer, player):
        player_score += 1
        return "You win this round!"
    else:
        cpu_score += 1
        return "You lost the game!"
    
if __name__=="__main__":
    main()



