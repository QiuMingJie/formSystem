
/****** Object:  Table [dbo].[SM_User]    Script Date: 08/02/2020 09:35:45 ******/

INSERT [dbo].[SM_User] ([user_identity], [role_identity], [user_number], [user_name], [user_short_name], [password], [dept_code], [ime], [phone_no], [title], [degreede], [flag], [remark], [签名图片], [可实施最高ASA分级], [可实施最高手术分级]) VALUES (1, 14, N'SF452402199703133944', N'叶建眉', N'', N'a300549b1292442df6593433d411ce', N'', N'', N'', N'', N'', N'1 ', N'', 0x89504E470D0A1A0A0000000D49484452000000640000002F08020000009A1FF8AC000000097048597300000EC400000EC401952B0E1B000002214944415478DAED99FD99C32008C69DCB819CC769588661AE7EDC253540027DCC354DF1CF9620FEF28268C28F0FF5088EC061392C87E5B01C96C372040ECB61392C87052926C0199E3037573A5F08D936AB2DCE9360618E218498718E27ADA36E9CF4A346A90FF344586654C8EA075208090ECD565883F19313261ED17E0A2CC4AD681138192B609594A16FB93D33FE13AB58E2C64C58E0B560B549A98EC97C766509CB21CADAF57C41584F934AB3596189A8245845D08CA2BF01D6EA85E4A690864DD0816C64BDC033153EF6E4650BFC67C122257C7E1ACED987FE0F566998329A51BD0E8BEE459C7300C3EAE7C0C2CCE99BEE047499E3DA5B57B04945260D55B0C85E24B559FAAE749AB210EDFA86DEBA46D23CEC290B92BCBA6A3BC03AE85E8C59FBDE9A55150907BE8ED2540AEF76B03454C69F3167F856584F4797E591BD9A25F4C05C342D25E371CD3A17D61081309D1A565E1E96D2CD9086C3ABBC611A16C3FEB8C884FB836F43C6602E098BBD1032D42C48D5F0EF1493D35107BFB42164DE31B82BC08A492918CB25548C517B3654CFF9FE9A75CE3902D2CE1BD6C2DA4EF97E659D01ABDFAAB67ED47291C0D80D667784D54F25D02FDB5BE28CC8949E8A9B8DD5DD6095A3CBB83FD416EB5766A5A8B782539AD061E4BC14FEB880AD658F3B26DDA566552ED2A7186C7D692FFBF2582997E3229DEB7394A5DD35A7BC18C8F05A08F516C712A47F6475580ECB61392C87E5C361392C87E5B01C96C3F2F100D36CCFF3E2EF1FD90000000049454E44AE426082, N'5', N'4')
INSERT [dbo].[SM_User] ([user_identity], [role_identity], [user_number], [user_name], [user_short_name], [password], [dept_code], [ime], [phone_no], [title], [degreede], [flag], [remark], [签名图片], [可实施最高ASA分级], [可实施最高手术分级]) VALUES (39, 12, N'admin', N'管理员', N'管理员', N'81dc9bdb52d04dc20036dbd8313ed0', N'', N'', N'', N'', N'', N'1 ', N'', NULL, N'5', N'4')

/****** Object:  Table [dbo].[ops_queue]    Script Date: 08/02/2020 09:35:45 ******/
INSERT [dbo].[ops_queue] ([operation_id], [asa], [amount_bleeding], [analgesia_formula], [anesthesia_endtime], [anesthesia_starttime], [anesthetic_assistant1], [anesthetic_assistant1code], [anesthetic_assistant1shift_datetime], [anesthetic_assistant2], [anesthetic_assistant2code], [anesthetic_assistant2shift_datetime], [anesthetic_assistant3], [anesthetic_assistant3code], [anesthetic_assistant3shift_datetime], [anesthetic_doctor], [anesthetic_doctor_code], [anesthetic_doctor_shift_datetime], [anesthetic_method], [anesthetic_method_code], [apparatus_nurse], [application_dept], [application_dept_code], [application_form_number], [application_person], [application_person_code], [application_time], [body_position], [canceled_cause], [canceled_person], [canceled_time], [checked_person], [checked_person_code], [circulating_nurse], [circulating_nurse2], [circulating_nurse2code], [circulating_nurse3], [circulating_nurse3code], [circulating_nurse_code], [circulating_relief_datetime1], [circulating_relief_datetime2], [circulating_relief_datetime3], [circulating_relief_nurse1], [circulating_relief_nurse1code], [circulating_relief_nurse2], [circulating_relief_nurse2code], [circulating_relief_nurse3], [circulating_relief_nurse3code], [tbcondition], [dept_code], [emergency_or_not], [enter_room_time], [exit_room_time], [green_channel], [heart_function], [incision_type], [infection_type], [inpatient_id], [inpatient_or_outpatient], [instrument_name], [intended_operation1], [intended_operation1code], [intended_operation2], [intended_operation2code], [intended_operation3], [intended_operation3code], [intended_operation4], [intended_operation4code], [intended_operation5], [intended_operation5code], [intended_operation6], [intended_operation6code], [ipid], [is_anesthing], [is_endoscopic_surgery], [is_monitoring], [is_open_surgery], [is_postoperative_visits], [is_preoperation_fasting], [is_preoperative_visits], [is_printed], [isolation], [monitoring_endtime], [monitoring_starttime], [operation_assistant1], [operation_assistant1code], [operation_assistant2], [operation_assistant2code], [operation_assistant3], [operation_assistant3code], [operation_assistant4], [operation_assistant4code], [operation_assistant5], [operation_assistant5code], [operation_datetime], [operation_doctor], [operation_doctor_code], [operation_endtime], [operation_finishstate], [operation_lv], [operation_method_post], [operation_method_post2], [operation_method_post2code], [operation_method_post3], [operation_method_post3code], [operation_method_post4], [operation_method_post4code], [operation_method_post5], [operation_method_post5code], [operation_method_post6], [operation_method_post6code], [operation_method_post_code], [operation_no], [operation_position], [operation_room], [operation_starttime], [operation_state], [operation_state_notfinal_reason], [others], [outpatient_id], [patient_bed], [patient_dep_room], [patient_dept], [patient_height], [patient_id], [patient_state], [patient_ward], [patient_weight], [postopera_analgesia], [postoperation_diagnosis], [postoperation_diagnosis_code], [postoperative_death], [preanesth_medication], [preoperation_diagnosis], [preoperation_diagnosis_code], [register_person], [register_person_code], [register_time], [relief_anesthetic_assistant1], [relief_anesthetic_assistant1code], [relief_anesthetic_assistant2], [relief_anesthetic_assistant2code], [relief_anesthetic_assistant3], [relief_anesthetic_assistant3code], [relief_anesthetic_doctor], [relief_anesthetic_doctor_code], [request_datetime], [scrub_nurse], [scrub_nurse2], [scrub_nurse2code], [scrub_nurse3], [scrub_nurse3code], [scrub_nurse_code], [scrub_relief_datetime1], [scrub_relief_datetime2], [scrub_relief_datetime3], [scrub_relief_nurse1], [scrub_relief_nurse1code], [scrub_relief_nurse2], [scrub_relief_nurse2code], [scrub_relief_nurse3], [scrub_relief_nurse3code], [special_case], [special_instrument], [urinary_production], [ward_code]) VALUES (N'123456789', N'4324', N'66', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'mingjie', NULL, NULL, N'111kg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[ops_queue] ([operation_id], [asa], [amount_bleeding], [analgesia_formula], [anesthesia_endtime], [anesthesia_starttime], [anesthetic_assistant1], [anesthetic_assistant1code], [anesthetic_assistant1shift_datetime], [anesthetic_assistant2], [anesthetic_assistant2code], [anesthetic_assistant2shift_datetime], [anesthetic_assistant3], [anesthetic_assistant3code], [anesthetic_assistant3shift_datetime], [anesthetic_doctor], [anesthetic_doctor_code], [anesthetic_doctor_shift_datetime], [anesthetic_method], [anesthetic_method_code], [apparatus_nurse], [application_dept], [application_dept_code], [application_form_number], [application_person], [application_person_code], [application_time], [body_position], [canceled_cause], [canceled_person], [canceled_time], [checked_person], [checked_person_code], [circulating_nurse], [circulating_nurse2], [circulating_nurse2code], [circulating_nurse3], [circulating_nurse3code], [circulating_nurse_code], [circulating_relief_datetime1], [circulating_relief_datetime2], [circulating_relief_datetime3], [circulating_relief_nurse1], [circulating_relief_nurse1code], [circulating_relief_nurse2], [circulating_relief_nurse2code], [circulating_relief_nurse3], [circulating_relief_nurse3code], [tbcondition], [dept_code], [emergency_or_not], [enter_room_time], [exit_room_time], [green_channel], [heart_function], [incision_type], [infection_type], [inpatient_id], [inpatient_or_outpatient], [instrument_name], [intended_operation1], [intended_operation1code], [intended_operation2], [intended_operation2code], [intended_operation3], [intended_operation3code], [intended_operation4], [intended_operation4code], [intended_operation5], [intended_operation5code], [intended_operation6], [intended_operation6code], [ipid], [is_anesthing], [is_endoscopic_surgery], [is_monitoring], [is_open_surgery], [is_postoperative_visits], [is_preoperation_fasting], [is_preoperative_visits], [is_printed], [isolation], [monitoring_endtime], [monitoring_starttime], [operation_assistant1], [operation_assistant1code], [operation_assistant2], [operation_assistant2code], [operation_assistant3], [operation_assistant3code], [operation_assistant4], [operation_assistant4code], [operation_assistant5], [operation_assistant5code], [operation_datetime], [operation_doctor], [operation_doctor_code], [operation_endtime], [operation_finishstate], [operation_lv], [operation_method_post], [operation_method_post2], [operation_method_post2code], [operation_method_post3], [operation_method_post3code], [operation_method_post4], [operation_method_post4code], [operation_method_post5], [operation_method_post5code], [operation_method_post6], [operation_method_post6code], [operation_method_post_code], [operation_no], [operation_position], [operation_room], [operation_starttime], [operation_state], [operation_state_notfinal_reason], [others], [outpatient_id], [patient_bed], [patient_dep_room], [patient_dept], [patient_height], [patient_id], [patient_state], [patient_ward], [patient_weight], [postopera_analgesia], [postoperation_diagnosis], [postoperation_diagnosis_code], [postoperative_death], [preanesth_medication], [preoperation_diagnosis], [preoperation_diagnosis_code], [register_person], [register_person_code], [register_time], [relief_anesthetic_assistant1], [relief_anesthetic_assistant1code], [relief_anesthetic_assistant2], [relief_anesthetic_assistant2code], [relief_anesthetic_assistant3], [relief_anesthetic_assistant3code], [relief_anesthetic_doctor], [relief_anesthetic_doctor_code], [request_datetime], [scrub_nurse], [scrub_nurse2], [scrub_nurse2code], [scrub_nurse3], [scrub_nurse3code], [scrub_nurse_code], [scrub_relief_datetime1], [scrub_relief_datetime2], [scrub_relief_datetime3], [scrub_relief_nurse1], [scrub_relief_nurse1code], [scrub_relief_nurse2], [scrub_relief_nurse2code], [scrub_relief_nurse3], [scrub_relief_nurse3code], [special_case], [special_instrument], [urinary_production], [ward_code]) VALUES (N'patientLiaoOpertion1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'1的次级vip科室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'1的廖的vip科室', NULL, N'patientLiao', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[ops_queue] ([operation_id], [asa], [amount_bleeding], [analgesia_formula], [anesthesia_endtime], [anesthesia_starttime], [anesthetic_assistant1], [anesthetic_assistant1code], [anesthetic_assistant1shift_datetime], [anesthetic_assistant2], [anesthetic_assistant2code], [anesthetic_assistant2shift_datetime], [anesthetic_assistant3], [anesthetic_assistant3code], [anesthetic_assistant3shift_datetime], [anesthetic_doctor], [anesthetic_doctor_code], [anesthetic_doctor_shift_datetime], [anesthetic_method], [anesthetic_method_code], [apparatus_nurse], [application_dept], [application_dept_code], [application_form_number], [application_person], [application_person_code], [application_time], [body_position], [canceled_cause], [canceled_person], [canceled_time], [checked_person], [checked_person_code], [circulating_nurse], [circulating_nurse2], [circulating_nurse2code], [circulating_nurse3], [circulating_nurse3code], [circulating_nurse_code], [circulating_relief_datetime1], [circulating_relief_datetime2], [circulating_relief_datetime3], [circulating_relief_nurse1], [circulating_relief_nurse1code], [circulating_relief_nurse2], [circulating_relief_nurse2code], [circulating_relief_nurse3], [circulating_relief_nurse3code], [tbcondition], [dept_code], [emergency_or_not], [enter_room_time], [exit_room_time], [green_channel], [heart_function], [incision_type], [infection_type], [inpatient_id], [inpatient_or_outpatient], [instrument_name], [intended_operation1], [intended_operation1code], [intended_operation2], [intended_operation2code], [intended_operation3], [intended_operation3code], [intended_operation4], [intended_operation4code], [intended_operation5], [intended_operation5code], [intended_operation6], [intended_operation6code], [ipid], [is_anesthing], [is_endoscopic_surgery], [is_monitoring], [is_open_surgery], [is_postoperative_visits], [is_preoperation_fasting], [is_preoperative_visits], [is_printed], [isolation], [monitoring_endtime], [monitoring_starttime], [operation_assistant1], [operation_assistant1code], [operation_assistant2], [operation_assistant2code], [operation_assistant3], [operation_assistant3code], [operation_assistant4], [operation_assistant4code], [operation_assistant5], [operation_assistant5code], [operation_datetime], [operation_doctor], [operation_doctor_code], [operation_endtime], [operation_finishstate], [operation_lv], [operation_method_post], [operation_method_post2], [operation_method_post2code], [operation_method_post3], [operation_method_post3code], [operation_method_post4], [operation_method_post4code], [operation_method_post5], [operation_method_post5code], [operation_method_post6], [operation_method_post6code], [operation_method_post_code], [operation_no], [operation_position], [operation_room], [operation_starttime], [operation_state], [operation_state_notfinal_reason], [others], [outpatient_id], [patient_bed], [patient_dep_room], [patient_dept], [patient_height], [patient_id], [patient_state], [patient_ward], [patient_weight], [postopera_analgesia], [postoperation_diagnosis], [postoperation_diagnosis_code], [postoperative_death], [preanesth_medication], [preoperation_diagnosis], [preoperation_diagnosis_code], [register_person], [register_person_code], [register_time], [relief_anesthetic_assistant1], [relief_anesthetic_assistant1code], [relief_anesthetic_assistant2], [relief_anesthetic_assistant2code], [relief_anesthetic_assistant3], [relief_anesthetic_assistant3code], [relief_anesthetic_doctor], [relief_anesthetic_doctor_code], [request_datetime], [scrub_nurse], [scrub_nurse2], [scrub_nurse2code], [scrub_nurse3], [scrub_nurse3code], [scrub_nurse_code], [scrub_relief_datetime1], [scrub_relief_datetime2], [scrub_relief_datetime3], [scrub_relief_nurse1], [scrub_relief_nurse1code], [scrub_relief_nurse2], [scrub_relief_nurse2code], [scrub_relief_nurse3], [scrub_relief_nurse3code], [special_case], [special_instrument], [urinary_production], [ward_code]) VALUES (N'patientLiaoOpertion2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'次级vip科室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'廖的vip科室', NULL, N'patientLiao', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[ops_queue] ([operation_id], [asa], [amount_bleeding], [analgesia_formula], [anesthesia_endtime], [anesthesia_starttime], [anesthetic_assistant1], [anesthetic_assistant1code], [anesthetic_assistant1shift_datetime], [anesthetic_assistant2], [anesthetic_assistant2code], [anesthetic_assistant2shift_datetime], [anesthetic_assistant3], [anesthetic_assistant3code], [anesthetic_assistant3shift_datetime], [anesthetic_doctor], [anesthetic_doctor_code], [anesthetic_doctor_shift_datetime], [anesthetic_method], [anesthetic_method_code], [apparatus_nurse], [application_dept], [application_dept_code], [application_form_number], [application_person], [application_person_code], [application_time], [body_position], [canceled_cause], [canceled_person], [canceled_time], [checked_person], [checked_person_code], [circulating_nurse], [circulating_nurse2], [circulating_nurse2code], [circulating_nurse3], [circulating_nurse3code], [circulating_nurse_code], [circulating_relief_datetime1], [circulating_relief_datetime2], [circulating_relief_datetime3], [circulating_relief_nurse1], [circulating_relief_nurse1code], [circulating_relief_nurse2], [circulating_relief_nurse2code], [circulating_relief_nurse3], [circulating_relief_nurse3code], [tbcondition], [dept_code], [emergency_or_not], [enter_room_time], [exit_room_time], [green_channel], [heart_function], [incision_type], [infection_type], [inpatient_id], [inpatient_or_outpatient], [instrument_name], [intended_operation1], [intended_operation1code], [intended_operation2], [intended_operation2code], [intended_operation3], [intended_operation3code], [intended_operation4], [intended_operation4code], [intended_operation5], [intended_operation5code], [intended_operation6], [intended_operation6code], [ipid], [is_anesthing], [is_endoscopic_surgery], [is_monitoring], [is_open_surgery], [is_postoperative_visits], [is_preoperation_fasting], [is_preoperative_visits], [is_printed], [isolation], [monitoring_endtime], [monitoring_starttime], [operation_assistant1], [operation_assistant1code], [operation_assistant2], [operation_assistant2code], [operation_assistant3], [operation_assistant3code], [operation_assistant4], [operation_assistant4code], [operation_assistant5], [operation_assistant5code], [operation_datetime], [operation_doctor], [operation_doctor_code], [operation_endtime], [operation_finishstate], [operation_lv], [operation_method_post], [operation_method_post2], [operation_method_post2code], [operation_method_post3], [operation_method_post3code], [operation_method_post4], [operation_method_post4code], [operation_method_post5], [operation_method_post5code], [operation_method_post6], [operation_method_post6code], [operation_method_post_code], [operation_no], [operation_position], [operation_room], [operation_starttime], [operation_state], [operation_state_notfinal_reason], [others], [outpatient_id], [patient_bed], [patient_dep_room], [patient_dept], [patient_height], [patient_id], [patient_state], [patient_ward], [patient_weight], [postopera_analgesia], [postoperation_diagnosis], [postoperation_diagnosis_code], [postoperative_death], [preanesth_medication], [preoperation_diagnosis], [preoperation_diagnosis_code], [register_person], [register_person_code], [register_time], [relief_anesthetic_assistant1], [relief_anesthetic_assistant1code], [relief_anesthetic_assistant2], [relief_anesthetic_assistant2code], [relief_anesthetic_assistant3], [relief_anesthetic_assistant3code], [relief_anesthetic_doctor], [relief_anesthetic_doctor_code], [request_datetime], [scrub_nurse], [scrub_nurse2], [scrub_nurse2code], [scrub_nurse3], [scrub_nurse3code], [scrub_nurse_code], [scrub_relief_datetime1], [scrub_relief_datetime2], [scrub_relief_datetime3], [scrub_relief_nurse1], [scrub_relief_nurse1code], [scrub_relief_nurse2], [scrub_relief_nurse2code], [scrub_relief_nurse3], [scrub_relief_nurse3code], [special_case], [special_instrument], [urinary_production], [ward_code]) VALUES (N'patientQiuOpertion1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'vip病房', NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'vip科室', NULL, N'patientQiu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[ops_queue] ([operation_id], [asa], [amount_bleeding], [analgesia_formula], [anesthesia_endtime], [anesthesia_starttime], [anesthetic_assistant1], [anesthetic_assistant1code], [anesthetic_assistant1shift_datetime], [anesthetic_assistant2], [anesthetic_assistant2code], [anesthetic_assistant2shift_datetime], [anesthetic_assistant3], [anesthetic_assistant3code], [anesthetic_assistant3shift_datetime], [anesthetic_doctor], [anesthetic_doctor_code], [anesthetic_doctor_shift_datetime], [anesthetic_method], [anesthetic_method_code], [apparatus_nurse], [application_dept], [application_dept_code], [application_form_number], [application_person], [application_person_code], [application_time], [body_position], [canceled_cause], [canceled_person], [canceled_time], [checked_person], [checked_person_code], [circulating_nurse], [circulating_nurse2], [circulating_nurse2code], [circulating_nurse3], [circulating_nurse3code], [circulating_nurse_code], [circulating_relief_datetime1], [circulating_relief_datetime2], [circulating_relief_datetime3], [circulating_relief_nurse1], [circulating_relief_nurse1code], [circulating_relief_nurse2], [circulating_relief_nurse2code], [circulating_relief_nurse3], [circulating_relief_nurse3code], [tbcondition], [dept_code], [emergency_or_not], [enter_room_time], [exit_room_time], [green_channel], [heart_function], [incision_type], [infection_type], [inpatient_id], [inpatient_or_outpatient], [instrument_name], [intended_operation1], [intended_operation1code], [intended_operation2], [intended_operation2code], [intended_operation3], [intended_operation3code], [intended_operation4], [intended_operation4code], [intended_operation5], [intended_operation5code], [intended_operation6], [intended_operation6code], [ipid], [is_anesthing], [is_endoscopic_surgery], [is_monitoring], [is_open_surgery], [is_postoperative_visits], [is_preoperation_fasting], [is_preoperative_visits], [is_printed], [isolation], [monitoring_endtime], [monitoring_starttime], [operation_assistant1], [operation_assistant1code], [operation_assistant2], [operation_assistant2code], [operation_assistant3], [operation_assistant3code], [operation_assistant4], [operation_assistant4code], [operation_assistant5], [operation_assistant5code], [operation_datetime], [operation_doctor], [operation_doctor_code], [operation_endtime], [operation_finishstate], [operation_lv], [operation_method_post], [operation_method_post2], [operation_method_post2code], [operation_method_post3], [operation_method_post3code], [operation_method_post4], [operation_method_post4code], [operation_method_post5], [operation_method_post5code], [operation_method_post6], [operation_method_post6code], [operation_method_post_code], [operation_no], [operation_position], [operation_room], [operation_starttime], [operation_state], [operation_state_notfinal_reason], [others], [outpatient_id], [patient_bed], [patient_dep_room], [patient_dept], [patient_height], [patient_id], [patient_state], [patient_ward], [patient_weight], [postopera_analgesia], [postoperation_diagnosis], [postoperation_diagnosis_code], [postoperative_death], [preanesth_medication], [preoperation_diagnosis], [preoperation_diagnosis_code], [register_person], [register_person_code], [register_time], [relief_anesthetic_assistant1], [relief_anesthetic_assistant1code], [relief_anesthetic_assistant2], [relief_anesthetic_assistant2code], [relief_anesthetic_assistant3], [relief_anesthetic_assistant3code], [relief_anesthetic_doctor], [relief_anesthetic_doctor_code], [request_datetime], [scrub_nurse], [scrub_nurse2], [scrub_nurse2code], [scrub_nurse3], [scrub_nurse3code], [scrub_nurse_code], [scrub_relief_datetime1], [scrub_relief_datetime2], [scrub_relief_datetime3], [scrub_relief_nurse1], [scrub_relief_nurse1code], [scrub_relief_nurse2], [scrub_relief_nurse2code], [scrub_relief_nurse3], [scrub_relief_nurse3code], [special_case], [special_instrument], [urinary_production], [ward_code]) VALUES (N'patientQiuOpertion2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'vip病房', NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'vip科室', NULL, N'patientQiu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
/****** Object:  Table [dbo].[form_dict]    Script Date: 08/02/2020 09:35:45 ******/
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0001_0001', CAST(0x0000AB52015A098C AS DateTime), 0, N'', CAST(0x0000AB52015A098C AS DateTime), 0, N'测试1表11单', N'', NULL, N'')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0001_0002', CAST(0x0000AB52015A098C AS DateTime), 0, N'', CAST(0x0000AB52015A098C AS DateTime), 0, N'测试1表11单', N'', NULL, N'11')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0002_0001', NULL, NULL, NULL, NULL, NULL, N'器械清点', NULL, 4, N'MachineCount')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0002_0002', NULL, NULL, NULL, NULL, NULL, N'手术护理记录单', NULL, 4, N'OpraNurseRec')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0002_0003', NULL, NULL, NULL, NULL, NULL, N'手术室手术病人访式表', NULL, 3, N'OpraVisiteTable')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0002_0004', NULL, NULL, NULL, NULL, NULL, N'手术患者术前压疮风险评估单（手术室）', NULL, 1, N'PressureRisk')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0002_0006', NULL, NULL, NULL, NULL, NULL, N'输血护理观察记录单', NULL, -1, N'BloodTransfusionRec')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0002_0007', NULL, NULL, NULL, NULL, NULL, N'手术患者转交接记录单', NULL, -1, N'OpraPatientTransRec')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0003_0003', NULL, NULL, NULL, NULL, NULL, N'麻醉术前访视记录单', NULL, 1, N'AnesthesiaBrforeOpra')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0003_0004', NULL, NULL, NULL, NULL, NULL, N'麻醉经过及术后访视', NULL, 3, N'AnesthesiaInterview')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0003_0005', NULL, NULL, NULL, NULL, NULL, N'麻醉知情同意书', NULL, 1, N'AnesthesiaKonwed')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0003_0006', NULL, NULL, NULL, NULL, NULL, N'术后镇痛知情同意书', NULL, 1, N'AnesthesiaAfterOpraKonwed')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0003_0007', NULL, NULL, NULL, NULL, NULL, N'使用自费、高费用项目同意书', NULL, -1, N'UseExpensiveKnowed')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0003_0008', NULL, NULL, NULL, NULL, NULL, N'自费药品、医保乙类药品及大型检查申请审批表', NULL, -1, N'LargeExamApprove')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'E0003_0009', NULL, NULL, NULL, NULL, NULL, N'医保乙类、丙类诊疗项目、材料及贵重耗材申请审批表', NULL, -1, N'ConsumApprove')
INSERT [dbo].[form_dict] ([form_dict_id], [create_date_time], [delete_flag], [remark], [update_date_time], [use_flag], [form_name], [form_type], [sign_num], [repository_class_name]) VALUES (N'I0001_0001', CAST(0x0000AB5201246EE4 AS DateTime), NULL, NULL, CAST(0x0000AB5201259F94 AS DateTime), NULL, N'测试1表11单', NULL, NULL, NULL)