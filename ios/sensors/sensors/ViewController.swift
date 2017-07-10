//
//  ViewController.swift
//  sensors
//
//  Created by Jason He on 27/06/17.
//  Copyright © 2017 Jason He. All rights reserved.
//

import UIKit
import CoreMotion

class ViewController: UIViewController {

    let manager = CMMotionManager()

    @IBOutlet weak var lblAcc: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        
        if manager.isAccelerometerAvailable {
            manager.accelerometerUpdateInterval = 0.1
            manager.startAccelerometerUpdates(to: OperationQueue.current!, withHandler: { (data, err) in
                if let acc = data {
                    let disp = "X = \(acc.acceleration.x) Y = \(acc.acceleration.y) Z = \(acc.acceleration.z)"
                    print(disp)
                    self.lblAcc.text = disp
                } else {
                    self.lblAcc.text = "No data"
                }
            })
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

