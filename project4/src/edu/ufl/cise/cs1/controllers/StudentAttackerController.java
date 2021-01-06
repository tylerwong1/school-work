package edu.ufl.cise.cs1.controllers;
import game.controllers.AttackerController;
import game.models.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class StudentAttackerController implements AttackerController
{
	public void init(Game game) { }

	public void shutdown(Game game) { }

	public int update(Game game,long timeDue)
	{
		int action = 0;
		// gator object
		Attacker gator = game.getAttacker();
		// list of powerpills
		List<Node> powerPill = game.getPowerPillList();
		// list of pills
		List<Node> pill = game.getPillList();
		// list of defenders
		List<Defender> defenders = game.getDefenders();
		// find ghost closest to gator
		Defender closestGhost = (Defender) gator.getTargetActor(defenders, true);

		// closest pill to gator
		Node targetPill = gator.getTargetNode(pill, true);

		// if ghosts aren't vulnerable
		if (!closestGhost.isVulnerable()) {
			// if targetpill is a pill go towards it
			if (game.checkPill(targetPill)) {
				action = gator.getNextDir(targetPill, true);
			}
			// closest powerpill to gator
			for (int i = 0; i < powerPill.size(); i++) {
				Node targetPower = gator.getTargetNode(powerPill, true);
				if (game.checkPowerPill(targetPower) && gator.getLocation().getPathDistance(closestGhost.getLocation()) < 42) {
					action = gator.getNextDir(targetPower, true);
				}
			}
			// if the closest ghost is 5 spaces, run away from it
			if (gator.getLocation().getPathDistance(closestGhost.getLocation()) < 5) {
				action = gator.getNextDir(closestGhost.getLocation(), false);
			}
		}
		// if ghosts are vulnerable eat VULERNABLE ghosts
		if (closestGhost.isVulnerable()) {
			action = gator.getNextDir(closestGhost.getLocation(), true);
		}
	return action;
	}
}