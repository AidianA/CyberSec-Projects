import unittest
import Rock_paper_scissors_game

def determine_winner(player, computer):
    Rock_paper_scissors_game.play(computer, player)
    
    if Rock_paper_scissors_game.check_if_a_tie(computer, player):
        return "It's a tie!"
    elif Rock_paper_scissors_game.check_if_player_wins(computer, player):
        return "You win!"
    else:
        return "Computer wins!"

class TestRockPaperScissors(unittest.TestCase):
    def test_tie(self):
        self.assertEqual(determine_winner("rock", "rock"), "It's a tie!")
        self.assertEqual(determine_winner("paper", "paper"), "It's a tie!")
        self.assertEqual(determine_winner("scissors", "scissors"), "It's a tie!")

    def test_user_wins(self):
        self.assertEqual(determine_winner("rock", "scissors"), "You win!")
        self.assertEqual(determine_winner("paper", "rock"), "You win!")
        self.assertEqual(determine_winner("scissors", "paper"), "You win!")

    def test_computer_wins(self):
        self.assertEqual(determine_winner("scissors", "rock"), "Computer wins!")
        self.assertEqual(determine_winner("rock", "paper"), "Computer wins!")
        self.assertEqual(determine_winner("paper", "scissors"), "Computer wins!")

if __name__ == '__main__':
    unittest.main()